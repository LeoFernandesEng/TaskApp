package com.project.br.taskapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.project.br.taskapp.R
import com.project.br.taskapp.repository.DatabaseUtil
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edt_Email : TextView
    private lateinit var edt_Senha : TextView
    private lateinit var twLoginRegister: TextView
    private lateinit var btLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt_Email = findViewById(R.id.login_edittext_email)
        edt_Senha = findViewById(R.id.login_edittext_senha)

        btLogin = findViewById(R.id.login_button_entrar)
        btLogin.setOnClickListener(this)

        twLoginRegister = findViewById(R.id.login_textview_registrar)
        twLoginRegister.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()

        edt_Email.text = ""
        edt_Senha.text = ""
    }

    override fun onClick(view: View?) {


        when(view?.id){
            R.id.login_textview_registrar -> {
                var intent : Intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
            R.id.login_button_entrar -> execLoginAction()
        }
    }

    private fun execLoginAction() {
        val email = edt_Email.text.toString().trim()
        val senha = edt_Senha.text.toString().trim()

        var isFormFilled : Boolean = true

        if(email.isBlank()){
            edt_Email.error = "Campo obrigatório"
            isFormFilled = false
        }

        if(senha.isBlank()){
            edt_Senha.error = "Campo obrigatório"
            isFormFilled = false
        }

        val handler = Handler(Looper.myLooper()!!)

        if(isFormFilled){
            GlobalScope.launch {
                val userDAO = DatabaseUtil.getInstance(applicationContext).getUserDAO()
                val user = userDAO.findByEmail(email)
                if(user != null){
                    if(user.password == senha){
                        var it = Intent(applicationContext, MainActivity::class.java)
                        it.putExtra("userId", user.id)
                        startActivity(it)
                        finish()
                    }else{
                        handler.post{
                            showDialog("Usuário ou Senha inválido")
                        }
                    }
                }else{
                    handler.post{
                        showDialog("Usuário não existe")
                    }
                }
            }
        }

    }

    private fun showDialog(messege:String){
        val dialog = AlertDialog.Builder(this@LoginActivity)
            .setTitle("Gestão APP")
            .setMessage(messege)
            .setCancelable(false)
            .setPositiveButton("OK"){dialog, _ ->
                dialog.dismiss()
            }.create()
        dialog.show()
    }

}