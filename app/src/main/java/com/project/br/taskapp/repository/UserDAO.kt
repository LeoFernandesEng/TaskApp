package com.project.br.taskapp.repository

<<<<<<< HEAD
import androidx.room.*
import com.project.br.taskapp.entity.User

@Dao
=======
import android.provider.ContactsContract
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.project.br.taskapp.entity.User

>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
interface UserDAO {
    @Insert
    fun insert(user: User)

    @Update
    fun update(user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM users WHERE id = :id")
<<<<<<< HEAD
    fun findByID(id: Int): User
=======
    fun findByID(id : Int): User
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e

    @Query("SELECT * FROM users WHERE email = :email")
    fun findByEmail(email: String): User

    @Query("SELECT * FROM users")
    fun findAll(): List<User>

}