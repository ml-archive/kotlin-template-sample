package dk.nodes.template.repositories

import dk.nodes.template.dao.ComicDao
import dk.nodes.template.models.entity.ComicEntity
import dk.nodes.template.models.mapper.ComicMapper
import dk.nodes.template.network.ComicApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ComicRepository @Inject constructor(
    private val remoteDataSource: ComicApi,
    private val localDataSource: ComicDao
) {
    suspend fun getComics(offset: Int, limit: Int): List<ComicEntity> {
        return remoteDataSource.getComics(offset, limit)
            .body()!!.data.results
            .map(ComicMapper::mapToEntity)
    }

    suspend fun insert(list: List<ComicEntity>) {
        localDataSource.insert(*list.toTypedArray())
    }

    fun all(): Flow<List<ComicEntity>> = localDataSource.comics()

    suspend fun getComicById(id: Long): ComicEntity? {
        return localDataSource.getComicById(id)
    }
}