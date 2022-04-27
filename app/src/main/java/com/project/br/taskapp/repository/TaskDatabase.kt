package com.project.br.taskapp.repository

import androidx.room.Database
import androidx.room.RoomDatabase
import com.project.br.taskapp.entity.User

@Database(entities = [User::class], version = 1)
abstract class TaskDatabase: RoomDatabase() {
    abstract fun getUserDAO(): UserDAO
}