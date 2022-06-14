package com.project.br.taskapp.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    tableName = "users",
    indices = [Index(value = ["email"], unique = true)]
)
data class User(
    @PrimaryKey val id:Int? = null,
    val name:String,
<<<<<<< HEAD
    val lastName:String,
    val phone:String,
    val email:String,
    val password:String
=======
    val email:String,
    val senha:String
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
)