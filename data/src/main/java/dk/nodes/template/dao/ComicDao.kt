package dk.nodes.template.dao

import androidx.room.Dao
import androidx.room.Query
import dk.nodes.template.domain.entity.ComicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicDao : EntityDao<ComicEntity> {

    @Query("SELECT * FROM ComicEntity ORDER BY ROWID")
    fun comics(): Flow<List<ComicEntity>>

    @Query("SELECT * FROM ComicEntity WHERE id =:id")
    suspend fun getComicById(id: Long): ComicEntity?
}