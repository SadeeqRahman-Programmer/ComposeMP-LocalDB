package com.sadeeq.localdb.composemultiplatform.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.sadeeq.localdb.composemultiplatform.repository.UserRepository
import com.sadeeq.localdb.composemultiplatform.viewModel.UserViewModel
import org.example.project.localDB.database.SQLDelightDemoDatabase

@Composable
fun UsersScreen(databaseFactory: SQLDelightDemoDatabase) {
    val repository = remember { UserRepository(databaseFactory) }
    val userViewModel: UserViewModel = remember {
        UserViewModel(repository)
    }
    var userName by remember { mutableStateOf("") }
    var mobileNumber by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp)
        ) {
            TextField(
                value = userName,
                onValueChange = { userName = it }
            )
            TextField(
                value = mobileNumber,
                onValueChange = { mobileNumber = it }
            )

            Button(
                onClick = {
                    userViewModel.saveNewUser(userName, mobileNumber)
                }
            ) {
                Text("Save User")
            }

        }
    }

}