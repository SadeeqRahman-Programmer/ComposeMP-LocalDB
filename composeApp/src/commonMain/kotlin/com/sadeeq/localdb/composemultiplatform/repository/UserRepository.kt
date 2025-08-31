package com.sadeeq.localdb.composemultiplatform.repository

import org.example.project.localDB.database.SQLDelightDemoDatabase

class UserRepository(
    private val db: SQLDelightDemoDatabase
) {
    private val userTableQueries = db.userTableQueries

    fun saveNewUser(
        userName:String,
        mobileNumber: String
    ){
        userTableQueries.insert(
            userName = userName,
            mobileNumber = mobileNumber
        )
    }
}