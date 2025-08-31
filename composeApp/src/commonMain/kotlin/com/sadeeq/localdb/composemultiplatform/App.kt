package com.sadeeq.localdb.composemultiplatform

import androidx.compose.runtime.*
import com.sadeeq.localdb.composemultiplatform.screen.UsersScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

import org.example.project.localDB.database.SQLDelightDemoDatabase

@Composable
@Preview
fun App(databaseFactory: SQLDelightDemoDatabase) {
    UsersScreen(databaseFactory)
}