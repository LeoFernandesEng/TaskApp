package com.project.br.taskapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.project.br.taskapp.R
import com.project.br.taskapp.entity.User
import com.project.br.taskapp.repository.DatabaseUtil

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edt_Name: EditText
    private lateinit var edt_Email: EditText
    private lateinit var edt_Senha: EditText
    private lateinit var edt_ConfirmarSenha: EditText
    private lateinit var btCadastrar : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edt_Name = findViewById(R.id.register_edittext_name)
        edt_Email = findViewById(R.id.register_edittext_email)
        edt_Senha = findViewById(R.id.register_edittext_senha)
        edt_ConfirmarSenha = findViewById(R.id.register_edittext_confirmarsenha)
        btCadastrar = findViewById(R.id.register_button_cadastrar)

        btCadastrar.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.register_button_cadastrar -> {
                doSaveAction()
            }
        }
    }

    private fun doSaveAction(){
        val name = edt_Name.text.toString().trim()
        val email = edt_Email.text.toString().trim()
        val senha = edt_Senha.text.toString().trim()
        val confirmarSenha = edt_ConfirmarSenha.text.toString().trim()

        var isFormFilled = true

        isFormFilled = isNameFilled(name) && isFormFilled
        isFormFilled = isEmailFilled(email) && isFormFilled
        isFormFilled = isSenhaFilled(senha) && isFormFilled
        isFormFilled = isConfirmarSenhaFilled(confirmarSenha) && isFormFilled

        if (isFormFilled){
            if(senha == confirmarSenha){

                val user = User(
                    name = name,
                    email = email,
                    senha = senha
                )

                val userDAO = DatabaseUtil.getInstance(applicationContext).getUserDAO()
                userDAO.insert(user)
                finish()

            }else{
                edt_ConfirmarSenha.error = "Não confere com a senha"
            }
        }


    }

    private fun isNameFilled(name: String): Boolean {
        return if (name.isBlank()) {
            edt_Name.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }

    private fun isEmailFilled(email: String): Boolean {
        return if (email.isBlank()) {
            edt_Email.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }

    private fun isSenhaFilled(senha: String): Boolean {
        return if (senha.isBlank()) {
            edt_Senha.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }

    private fun isConfirmarSenhaFilled(confirmaSenha: String): Boolean {
        return if (confirmaSenha.isBlank()) {
            edt_ConfirmarSenha.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }


}