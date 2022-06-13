package com.project.br.taskapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "transactions"
)
data class Transaction(
    @PrimaryKey
    val id : Int? = null,
    val nome: String,
    val description : String,
    val valor : Double,
    @ColumnInfo(name = "is_expense")
    val isExpense : Boolean, // é despesa ?
    val userId : Int
)
