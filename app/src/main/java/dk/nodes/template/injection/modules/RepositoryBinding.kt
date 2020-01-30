package dk.nodes.template.injection.modules

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dk.nodes.template.domain.repositories.ComicRepository
import dk.nodes.template.repositories.ComicRepositoryImpl
import dk.nodes.template.storage.AppRoomDatabase
import javax.inject.Singleton

@Module
abstract class RepositoryBinding {

    @Binds
    @Singleton
    abstract fun bindComicRepository(repository: ComicRepositoryImpl): ComicRepository

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun provideAppDatabase(context: Context): AppRoomDatabase {
            return Room.inMemoryDatabaseBuilder(context, AppRoomDatabase::class.java)
                .build()
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideComicDao(database: AppRoomDatabase) = database.comicDao()
    }
}