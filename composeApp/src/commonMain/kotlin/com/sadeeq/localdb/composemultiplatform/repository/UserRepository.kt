package com.sadeeq.localdb.composemultiplatform.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import org.example.project.localDB.database.SQLDelightDemoDatabase
import org.example.project.localDB.database.UserTable

class UserRepository(
    private val db: SQLDelightDemoDatabase
) {
    private val userTableQueries = db.userTableQueries

    fun saveNewUser(
        userName: String,
        mobileNumber: String
    ) {
        userTableQueries.insert(
            userName = userName,
            mobileNumber = mobileNumber
        )
    }

    fun getAllUsers(): Flow<List<UserTable>> =
        userTableQueries.selectAllUsers().asFlow()
            .mapToList(Dispatchers.Main)

    fun deleteUserById(userId: Long){
        userTableQueries.deleteUserById(id = userId)
    }

    fun updateUserInfo(
        userId: Long,
        mobileNumber: String,
        userName: String
    ){
        userTableQueries.updateUserInfo(
            userName = userName,
            mobileNumber = mobileNumber,
            id = userId
        )
    }
}