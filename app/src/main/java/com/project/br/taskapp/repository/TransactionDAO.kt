package com.project.br.taskapp.repository

import androidx.room.*
import com.project.br.taskapp.entity.TransactionApp
import com.project.br.taskapp.entity.UserWithTransactions

@Dao
interface TransactionDAO {

    @Insert
    fun insert(transactionApp: TransactionApp)

    @Update
    fun update(transactionApp: TransactionApp)

    @Delete
    fun delete(transactionApp: TransactionApp)

    @Query("SELECT * FROM transactions WHERE id = :id")
    fun findById(id:Int) : TransactionApp

    @androidx.room.Transaction
    @Query("SELECT * FROM users WHERE id = :userId")
    fun findByUserId(userId:Int) : UserWithTransactions

    @Query("SELECT * FROM transactions")
    fun findAll() : List<TransactionApp>

}