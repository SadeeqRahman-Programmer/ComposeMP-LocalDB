package com.sadeeq.localdb.composemultiplatform.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sadeeq.localdb.composemultiplatform.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
): ViewModel() {

    fun saveNewUser(
        userName:String,
        mobileNumber: String
    ){
        viewModelScope.launch { repository.saveNewUser(
            userName =  userName,
            mobileNumber = mobileNumber
        ) }
    }
}