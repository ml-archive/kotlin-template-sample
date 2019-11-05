package dk.nodes.template.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import dk.nodes.template.models.entity.ComicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ComicDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(comics: List<ComicEntity>)

    @Query("SELECT * FROM ComicEntity ORDER BY ROWID")
    fun comics(): Flow<List<ComicEntity>>
}