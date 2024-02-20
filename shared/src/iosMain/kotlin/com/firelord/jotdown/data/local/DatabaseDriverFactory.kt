package com.firelord.jotdown.data.local

import com.firelord.jotdown.database.JotDownDatabase
import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(JotDownDatabase.Schema, "jotdown.db")
    }
}