package com.project.br.taskapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "receitas"
)
data class Receita(
    @PrimaryKey
    val id : Int? = null,
    val nome: String,
    val description : String,
    val valor : Double,
    val userId : Int
)
