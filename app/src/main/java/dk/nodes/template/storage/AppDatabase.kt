package dk.nodes.template.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import dk.nodes.template.dao.ComicDao
import dk.nodes.template.domain.entity.ComicEntity

@Database(
    entities = [
        ComicEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun comicDao(): ComicDao
}