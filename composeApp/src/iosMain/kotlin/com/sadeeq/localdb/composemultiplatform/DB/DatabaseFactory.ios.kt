package com.sadeeq.localdb.composemultiplatform.DB

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import org.example.project.localDB.database.SQLDelightDemoDatabase

actual class DatabaseFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = SQLDelightDemoDatabase.Schema,
            name = "SQLDelightDemoDatabase.db"
        )
    }
}