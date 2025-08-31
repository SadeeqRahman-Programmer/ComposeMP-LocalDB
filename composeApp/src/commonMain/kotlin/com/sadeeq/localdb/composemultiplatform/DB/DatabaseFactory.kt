package com.sadeeq.localdb.composemultiplatform.DB

import app.cash.sqldelight.db.SqlDriver

expect class DatabaseFactory {
    fun createDriver(): SqlDriver
}