package com.project.br.taskapp.repository

import androidx.room.*
import com.project.br.taskapp.entity.User

@Dao
interface UserDAO {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
    fun findByID(id: Int): User

    @Query("SELECT * FROM users WHERE email = :email")
    fun findByEmail(email: String): User

    @Query("SELECT * FROM users")
    fun findAll(): List<User>

}