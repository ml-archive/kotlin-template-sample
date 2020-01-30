package dk.nodes.template.repositories

import dk.nodes.template.dao.ComicDao
import dk.nodes.template.domain.entity.ComicEntity
import dk.nodes.template.domain.repositories.ComicRepository
import dk.nodes.template.models.mapper.ComicMapper
import dk.nodes.template.network.ComicApi
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ComicRepositoryImpl @Inject constructor(
    private val remoteDataSource: ComicApi,
    private val localDataSource: ComicDao
) : ComicRepository {
    override suspend fun getComics(offset: Int, limit: Int): List<ComicEntity> {
        return remoteDataSource.getComicsCollection(offset = offset, limit = limit)
            .body()!!.data!!.results!!
            .map(ComicMapper::mapToEntity)
    }

    override suspend fun insert(list: List<ComicEntity>) {
        localDataSource.insertOrIgnore(*list.toTypedArray())
    }

    override fun all(): Flow<List<ComicEntity>> = localDataSource.comics()

    override suspend fun getComicById(id: Long): ComicEntity? {
        return localDataSource.getComicById(id)
            ?: getComicByIdRemoteSource(id)?.also { localDataSource.insert(it) }
    }

    private suspend fun getComicByIdRemoteSource(id: Long): ComicEntity? {
        return ComicMapper.mapToEntity(
            remoteDataSource.getComicIndividual(id)
                .body()!!
                .data?.results?.firstOrNull() ?: return null
        )
    }
}