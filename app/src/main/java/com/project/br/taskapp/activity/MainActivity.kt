package com.project.br.taskapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.br.taskapp.R

class MainActivity : AppCompatActivity() {

    lateinit var listReceita : RecyclerView
    lateinit var btAddReceita : FloatingActionButton

    private var userId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listReceita = findViewById(R.id.main_recycleview_receitas)
        btAddReceita = findViewById(R.id.main_fab_create_receita)

    }
}