package dk.nodes.template.presentation.ui.comics

import androidx.lifecycle.viewModelScope
import dk.nodes.arch.presentation.NodesViewModel
import dk.nodes.template.domain.interactors.GetAndInsertComicsInteractor
import dk.nodes.template.domain.interactors.isError
import dk.nodes.template.domain.interactors.isSuccess
import dk.nodes.template.presentation.util.SingleEvent
import dk.nodes.template.presentation.util.ViewErrorController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class ComicsViewModel @Inject constructor(private val getAndInsertComicsInteractor: GetAndInsertComicsInteractor) :
    NodesViewModel<ComicsViewState>() {

    override val initState: ComicsViewState = ComicsViewState()

    init {
        loadMore(0)
        viewModelScope.launch {
            getAndInsertComicsInteractor.flow()
                .collect {
                    state = state.copy(data = it)
                }
        }
    }

    fun loadMore(offset: Int) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            getAndInsertComicsInteractor(GetAndInsertComicsInteractor.Input(offset = offset)).isError {
                state = state.copy(
                    viewError = SingleEvent(ViewErrorController.mapThrowable(it)),
                    isLoading = false
                )
            }.isSuccess {
                state = state.copy(isLoading = false)
            }
        }
    }
}
