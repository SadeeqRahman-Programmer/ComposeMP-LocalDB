package com.sadeeq.localdb.composemultiplatform

import androidx.compose.ui.window.ComposeUIViewController
import com.sadeeq.localdb.composemultiplatform.DB.DatabaseFactory
import org.example.project.localDB.database.SQLDelightDemoDatabase
import org.example.project.localDB.database.SQLDelightDemoDatabase.Companion.invoke

fun MainViewController() = ComposeUIViewController {
    val databaseFactory = SQLDelightDemoDatabase(
        DatabaseFactory().createDriver()
    )
    App(databaseFactory) }