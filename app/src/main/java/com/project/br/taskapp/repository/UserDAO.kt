package com.project.br.taskapp.repository

import android.provider.ContactsContract
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.project.br.taskapp.entity.User

interface UserDAO {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    fun findByID(id : Int): User

    @Query("SELECT * FROM users WHERE email = :email")
    fun findByEmail(email: String): User

    @Query("SELECT * FROM users")
    fun findAll(): List<User>

}