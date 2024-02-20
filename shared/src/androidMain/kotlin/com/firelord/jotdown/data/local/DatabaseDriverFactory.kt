package com.firelord.jotdown.data.local

import android.content.Context
import com.firelord.jotdown.database.JotDownDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

actual class DatabaseDriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(JotDownDatabase.Schema, context, "jotdown.db")
    }
}