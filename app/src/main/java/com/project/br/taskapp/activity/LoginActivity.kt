package com.project.br.taskapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.project.br.taskapp.R

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var twLoginRegister: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        twLoginRegister = findViewById(R.id.login_textview_registrar)
        twLoginRegister.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.login_textview_registrar -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}