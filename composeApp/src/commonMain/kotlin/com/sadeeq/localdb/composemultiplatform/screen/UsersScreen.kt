package com.sadeeq.localdb.composemultiplatform.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sadeeq.localdb.composemultiplatform.repository.UserRepository
import com.sadeeq.localdb.composemultiplatform.viewModel.UserViewModel
import kotlinx.coroutines.Dispatchers
import org.example.project.localDB.database.SQLDelightDemoDatabase

@Composable
fun UsersScreen(databaseFactory: SQLDelightDemoDatabase) {
    val repository = remember { UserRepository(databaseFactory) }
    val userViewModel: UserViewModel = remember {
        UserViewModel(repository)
    }

    val usersList by userViewModel.userList.collectAsState(
        initial = emptyList(),
        context = Dispatchers.Main
    )
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

            LazyColumn {
                items(usersList.size){
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Text(
                            text = usersList[it].userName,
                            fontSize = 20.sp,
                            color = Color.Black
                        )
                        Text(
                            modifier = Modifier.padding(top = 10.dp),
                            text = usersList[it].mobileNumber,
                            fontSize = 15.sp,
                            color = Color.Gray
                        )
                    }
                }
            }

        }
    }

}