package com.project.br.taskapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.br.taskapp.entity.TransactionApp
import com.project.br.taskapp.entity.User

@Database(entities = [User::class, TransactionApp::class], version = 3)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
    abstract fun getTransactionDAO(): TransactionDAO

}