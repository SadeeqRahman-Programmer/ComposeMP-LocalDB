package com.sadeeq.localdb.composemultiplatform.DB

import android.content.Context
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.example.project.localDB.database.SQLDelightDemoDatabase

actual class DatabaseFactory(
    val context: Context
) {

    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = SQLDelightDemoDatabase.Schema,
            context = context,
            name = "SQLDelightDemoDatabase.db"
        )
    }
}