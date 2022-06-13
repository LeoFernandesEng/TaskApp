package com.project.br.taskapp.entity

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithTransactions(
    @Embedded
    val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "user_id"
    )
    val transactionApp: List<TransactionApp>
)
