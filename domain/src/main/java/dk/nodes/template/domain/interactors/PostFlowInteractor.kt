package dk.nodes.template.domain.interactors

import dk.nodes.template.models.Post
import dk.nodes.template.repositories.PostRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PostFlowInteractor @Inject constructor(
    private val postRepository: PostRepository
) : FlowInteractor<Unit, List<Post>>() {
    override suspend fun run(input: Unit) {
        postRepository.getPosts()
    }

    override fun flow(): Flow<List<Post>> {
        return postRepository.getPostsFlow()
    }
}