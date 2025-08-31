package com.sadeeq.localdb.composemultiplatform.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadeeq.localdb.composemultiplatform.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.example.project.localDB.database.UserTable

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    val userList: Flow<List<UserTable>> =
        repository.getAllUsers().stateIn(
            viewModelScope, SharingStarted.Lazily, emptyList()
        )

    fun saveNewUser(
        userName: String,
        mobileNumber: String
    ) {
        viewModelScope.launch {
            repository.saveNewUser(
                userName = userName,
                mobileNumber = mobileNumber
            )
        }
    }

    fun deleteUserById(userId: Long){
        viewModelScope.launch {
            repository.deleteUserById(userId)
        }
    }

    fun updateUserInfo(
        userId: Long,
        userName: String,
        mobileNumber: String
    ){
        viewModelScope.launch {
            repository.updateUserInfo(
                userId= userId,
                userName = userName,
                mobileNumber = mobileNumber
            )
        }
    }

    fun deleteAllRecords(){
        viewModelScope.launch {
            repository.deleteAllUsersRecord()
        }
    }
}