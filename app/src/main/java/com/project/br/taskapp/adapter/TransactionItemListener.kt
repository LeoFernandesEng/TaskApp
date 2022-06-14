package com.project.br.taskapp.adapter

import android.view.View

interface TransactionItemListener {

    fun onTransactionItemClick(view : View, position : Int)

    fun onTransactionItemLongClick(view : View, position : Int)
}