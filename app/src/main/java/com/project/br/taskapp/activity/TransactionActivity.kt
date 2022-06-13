package com.project.br.taskapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.project.br.taskapp.R

class TransactionActivity : AppCompatActivity() {

    private lateinit var edt_name : EditText
    private lateinit var edt_value : EditText
    private lateinit var edt_description : EditText
    private lateinit var check_despesa : CheckBox
    private lateinit var btn_registrar : Button

    private var userId = -1
    private var transactionId = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transaction)

        userId = intent.getIntExtra("userId", -1)
        transactionId = intent.getIntExtra("transactionId", -1)

        edt_name = findViewById(R.id.transaction_edittext_name)
        edt_value = findViewById(R.id.transaction_edittext_value)
        edt_description = findViewById(R.id.transaction_muilttext_description)
        check_despesa = findViewById(R.id.transaction_checkbox_despesa)

        btn_registrar = findViewById(R.id.transaction_button_registrar)

    }

    override fun onResume() {
        super.onResume()

        if(transactionId != -1){
            btn_registrar.text = "Atualizar"
        }else{
            btn_registrar.text = "Cadastrar"
        }

    }

}