package dk.nodes.template.domain.interactors

import dk.nodes.template.domain.entity.ComicEntity
import dk.nodes.template.domain.repositories.ComicRepository
import java.lang.RuntimeException
import javax.inject.Inject

class GetComicByIdInteractor @Inject constructor(private val comicRepository: ComicRepository) :
    Interactor<Long, ComicEntity> {
    override suspend fun invoke(input: Long): ComicEntity {
        return comicRepository.getComicById(input) ?: throw RuntimeException("Comic with id not found")
    }
}