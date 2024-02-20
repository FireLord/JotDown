package com.firelord.jotdown.di

import com.firelord.jotdown.data.local.DatabaseDriverFactory
import com.firelord.jotdown.data.note.SqlDelightNoteDataSource
import com.firelord.jotdown.database.JotDownDatabase
import com.firelord.jotdown.domain.note.NoteDataSource

class DatabaseModule {
    private val factory by lazy { DatabaseDriverFactory() }
    val noteDataSource: NoteDataSource by lazy {
        SqlDelightNoteDataSource(JotDownDatabase(factory.createDriver()))
    }
}