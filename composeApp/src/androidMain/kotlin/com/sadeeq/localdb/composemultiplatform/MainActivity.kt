package com.sadeeq.localdb.composemultiplatform

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sadeeq.localdb.composemultiplatform.DB.DatabaseFactory
import org.example.project.localDB.database.SQLDelightDemoDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        val databaseFactory = SQLDelightDemoDatabase(
            DatabaseFactory(this).createDriver()
        )
        setContent {
            App(databaseFactory)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
 }