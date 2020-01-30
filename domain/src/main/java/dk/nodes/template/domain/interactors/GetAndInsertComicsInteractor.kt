package dk.nodes.template.domain.interactors

import dk.nodes.template.domain.entity.ComicEntity
import dk.nodes.template.domain.repositories.ComicRepository
import javax.inject.Inject

class GetAndInsertComicsInteractor @Inject constructor(
    private val comicRepository: ComicRepository
) : FlowInteractor<GetAndInsertComicsInteractor.Input, List<ComicEntity>>() {
    override suspend fun run(input: Input) {
        val comics = comicRepository.getComics(
            input.offset,
            input.limit
        )
        comicRepository.insert(comics)
    }

    data class Input(
        val limit: Int = 20,
        val offset: Int = 0
    )

    override fun flow() = comicRepository.all()
}