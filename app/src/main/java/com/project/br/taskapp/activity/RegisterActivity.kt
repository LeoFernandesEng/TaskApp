package com.project.br.taskapp.activity

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.project.br.taskapp.R
import com.project.br.taskapp.entity.User
import com.project.br.taskapp.repository.DatabaseUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
=======
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
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edt_Name: EditText
<<<<<<< HEAD
    private lateinit var edt_LastName: EditText
    private lateinit var edt_Phone: EditText
=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
    private lateinit var edt_Email: EditText
    private lateinit var edt_Senha: EditText
    private lateinit var edt_ConfirmarSenha: EditText
    private lateinit var btCadastrar : Button

<<<<<<< HEAD
    private val handler = Handler(Looper.getMainLooper())

=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edt_Name = findViewById(R.id.register_edittext_name)
<<<<<<< HEAD
        edt_LastName = findViewById(R.id.register_edittext_lastname)
        edt_Phone = findViewById(R.id.register_edittext_fone)
=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
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
<<<<<<< HEAD
        val lastName = edt_LastName.text.toString().trim()
        val phone = edt_Phone.text.toString().trim()
=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
        val email = edt_Email.text.toString().trim()
        val senha = edt_Senha.text.toString().trim()
        val confirmarSenha = edt_ConfirmarSenha.text.toString().trim()

        var isFormFilled = true

        isFormFilled = isNameFilled(name) && isFormFilled
<<<<<<< HEAD
        isFormFilled = isLastNameFilled(lastName) && isFormFilled
        isFormFilled = isPhoneFilled(phone) && isFormFilled
=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
        isFormFilled = isEmailFilled(email) && isFormFilled
        isFormFilled = isSenhaFilled(senha) && isFormFilled
        isFormFilled = isConfirmarSenhaFilled(confirmarSenha) && isFormFilled

        if (isFormFilled){
            if(senha == confirmarSenha){

                val user = User(
                    name = name,
<<<<<<< HEAD
                    lastName = lastName,
                    phone = phone,
                    email = email,
                    password = senha
                )
                GlobalScope.launch {
                    val userDAO = DatabaseUtil.getInstance(applicationContext).getUserDAO()
                    userDAO.insert(user)
                }
                Toast.makeText(
                    applicationContext,
                    "Usuário $name cadastrado com sucesso",
                    Toast.LENGTH_SHORT
                ).show()

                handler.post{
                    val dialog = AlertDialog.Builder(this@RegisterActivity)
                        .setTitle("Gestão APP")
                        .setMessage("Usuário $name $lastName cadastrado com sucesso !")
                        .setCancelable(false)
                        .setPositiveButton("OK"){dialog, _ ->
                            dialog.dismiss()
                            finish()
                        }.create()
                    dialog.show()
                }
=======
                    email = email,
                    senha = senha
                )

                val userDAO = DatabaseUtil.getInstance(applicationContext).getUserDAO()
                userDAO.insert(user)
                finish()
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e

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

<<<<<<< HEAD
    private fun isLastNameFilled(lastName: String): Boolean {
        return if (lastName.isBlank()) {
            edt_LastName.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }

    private fun isPhoneFilled(phone: String): Boolean {
        return if (phone.isBlank()) {
            edt_Phone.error = "Campo obrigatório"
            false
        } else {
            true
        }
    }

=======
>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
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

<<<<<<< HEAD
=======

>>>>>>> 2284fe6c0cbb41a679d6fe9b4c82e02da5e02e4e
}