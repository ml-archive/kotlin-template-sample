package dk.nodes.template.domain.interactors

import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.repositories.ComicRepository
import javax.inject.Inject

class GetAndInsertComicsInteractor @Inject constructor(
    private val comicRepository: ComicRepository
) : FlowInteractor<GetAndInsertComicsInteractor.Input, List<ComicEntity>>() {
    override suspend fun run(input: Input) {
        comicRepository.insert(
            comicRepository.getComics(
                input.offset,
                input.limit
            )
        )
    }

    data class Input(
        val limit: Int = 20,
        val offset: Int = 0
    )

    override fun flow() = comicRepository.all()
}