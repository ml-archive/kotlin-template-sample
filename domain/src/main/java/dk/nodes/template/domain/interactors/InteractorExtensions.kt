package dk.nodes.template.domain.interactors

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.ConflatedBroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

interface ResultInteractor<I, O> : Interactor<I, CompleteResult<O>>

abstract class FlowInteractor<I, O> : ResultInteractor<I, Unit> {
    abstract fun flow(): Flow<O>
    protected abstract suspend fun run(input: I)
    override suspend fun invoke(input: I): CompleteResult<Unit> {
        return wrapAsResult { run(input) }
    }
}

private class ResultInteractorImpl<I, O>(private val interactor: Interactor<I, out O>) :
    ResultInteractor<I, O> {
    override suspend fun invoke(input: I): CompleteResult<O> {
        return try {
            Success(interactor(input))
        } catch (t: Throwable) {
            Fail(t)
        }
    }
}

private class FlowInteractorImpl<I, O>(private val interactor: Interactor<I, out O>) :
    FlowInteractor<I, InteractorResult<O>>() {
    override suspend fun run(input: I) {
        interactor(input)
    }

    private val channel = ConflatedBroadcastChannel<InteractorResult<O>>(Uninitialized)

    override fun flow(): Flow<InteractorResult<O>> {
        return channel.asFlow()
    }

    override suspend fun invoke(input: I): CompleteResult<Unit> {
        channel.offer(Loading())
        return try {
            channel.send(Success(interactor(input)))
            Success(Unit)
        } catch (t: Throwable) {
            Fail(t).also { channel.send(it) }
        }
    }
}

fun <I, O> Interactor<I, O>.asResult(): ResultInteractor<I, O> {
    return ResultInteractorImpl(this)
}

fun <I, O> Interactor<I, O>.asFlow(): FlowInteractor<I, InteractorResult<O>> {
    return FlowInteractorImpl(this)
}

fun <I> CoroutineScope.launchInteractor(
    interactor: NoOutputInteractor<I>,
    input: I,
    coroutineContext: CoroutineContext = Dispatchers.IO
) {
    launch(coroutineContext) { interactor(input) }
}

fun CoroutineScope.launchInteractor(
    interactor: EmptyInteractor,
    coroutineContext: CoroutineContext = Dispatchers.IO
) {
    launchInteractor(interactor, Unit, coroutineContext)
}

suspend fun <I, T> runInteractor(
    interactor: Interactor<I, T>,
    input: I,
    coroutineContext: CoroutineContext = Dispatchers.IO
): T {
    return withContext(coroutineContext) { interactor(input) }
}

suspend fun <O> runInteractor(
    interactor: NoInputInteractor<O>,
    coroutineContext: CoroutineContext = Dispatchers.IO
): O {
    return withContext(coroutineContext) { interactor.invoke() }
}

inline fun <T, R> InteractorResult<T>.isSuccess(block: (T) -> R): InteractorResult<T> {
    if (this is Success) {
        block(this.data)
    }
    return this
}

inline fun <T, R> InteractorResult<T>.isError(block: (throwable: Throwable) -> R): InteractorResult<T> {
    if (this is Fail) {
        block(this.throwable)
    }
    return this
}