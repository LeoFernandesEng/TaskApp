package com.project.br.taskapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.project.br.taskapp.R
import com.project.br.taskapp.entity.TransactionApp
import com.project.br.taskapp.repository.DatabaseUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TransactionActivity : AppCompatActivity() {

    private lateinit var edt_name : EditText
    private lateinit var edt_value : EditText
    private lateinit var edt_description : EditText
    private lateinit var check_despesa : CheckBox
    private lateinit var btn_registrar : Button

    private var userId = -1
    private var transactionId = -1
    private val handler = Handler(Looper.getMainLooper()!!)

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

        btn_registrar.setOnClickListener{
            val name = edt_name.text.toString().trim()
            val value = edt_value.text.toString().trim()
            val description = edt_description.text.toString()
            val isExpense = check_despesa.isChecked

            if(transactionId != -1){

            }else{
                GlobalScope.launch {
                    val transactionDAO = DatabaseUtil
                        .getInstance(applicationContext)
                        .getTransactionDAO()

                    val transactionApp = TransactionApp(name = name, value = value.toDouble(), description = description, isExpense = isExpense, userId = userId)
                    transactionDAO.insert(transactionApp)
                    handler.post{
                        val dialog = AlertDialog.Builder(this@TransactionActivity)
                            .setTitle("Gestão APP")
                            .setMessage("Transação Cadastrada com sucesso")
                            .setCancelable(true)
                            .setPositiveButton("OK"){dialog, _ ->
                                dialog.dismiss()
                                finish()
                            }.create()
                        dialog.show()
                    }
                }
            }


        }

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