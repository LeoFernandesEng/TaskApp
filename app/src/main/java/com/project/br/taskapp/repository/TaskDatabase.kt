package com.project.br.taskapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
<<<<<<< HEAD
import com.project.br.taskapp.entity.TransactionApp
import com.project.br.taskapp.entity.User

@Database(entities = [User::class, TransactionApp::class], version = 3)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
    abstract fun getTransactionDAO(): TransactionDAO
=======
import com.project.br.taskapp.entity.User

@Database(entities = [User::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
}