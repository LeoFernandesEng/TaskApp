package com.project.br.taskapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "transactions"
)
data class TransactionApp(
    @PrimaryKey
    val id : Int? = null,
    val name: String,
    val description : String,
    val value : Double,
    @ColumnInfo(name = "is_expense")
    val isExpense : Boolean, // é despesa ?
    @ColumnInfo(name = "user_id")
    val userId : Int
)
