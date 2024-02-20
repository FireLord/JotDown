package com.firelord.jotdown.android.di

import android.app.Application
import com.firelord.jotdown.data.local.DatabaseDriverFactory
import com.firelord.jotdown.data.note.SqlDelightNoteDataSource
import com.firelord.jotdown.database.JotDownDatabase
import com.firelord.jotdown.domain.note.NoteDataSource
import com.squareup.sqldelight.db.SqlDriver
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSqlDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).createDriver()
    }

    @Provides
    @Singleton
    fun provideNoteDataSource(sqlDriver: SqlDriver): NoteDataSource {
        return SqlDelightNoteDataSource(JotDownDatabase(sqlDriver))
    }
}