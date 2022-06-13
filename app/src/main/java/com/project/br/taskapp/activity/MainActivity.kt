package com.project.br.taskapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.br.taskapp.R

class MainActivity : AppCompatActivity() {

    lateinit var listTransaction : RecyclerView
    lateinit var btAddTransaction : FloatingActionButton

    private var userId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userId = intent.getIntExtra("userId", -1)

        listTransaction = findViewById(R.id.main_recycleview_transactions)
        btAddTransaction = findViewById(R.id.main_fab_create_transactions)

        btAddTransaction.setOnClickListener {
            val intent = Intent(this, TransactionActivity::class.java)
            intent.putExtra("userId", userId)
            startActivity(intent)
        }

    }
}