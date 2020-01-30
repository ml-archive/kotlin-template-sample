package dk.nodes.template.domain.repositories

import dk.nodes.template.domain.entity.ComicEntity
import kotlinx.coroutines.flow.Flow

interface ComicRepository {

    suspend fun getComics(offset: Int, limit: Int): List<ComicEntity>
    suspend fun insert(list: List<ComicEntity>)
    fun all(): Flow<List<ComicEntity>>
    suspend fun getComicById(id: Long): ComicEntity?
}