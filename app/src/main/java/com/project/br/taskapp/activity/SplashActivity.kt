package com.project.br.taskapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.project.br.taskapp.R
import com.project.br.taskapp.repository.DatabaseUtil

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //Ocultar barra de status
        actionBar?.hide()
        setContentView(R.layout.activity_splash)

        // Create a delay on activity
        Handler(Looper.myLooper()!!).postDelayed({
            startActivity(Intent(SplashActivity@this,LoginActivity::class.java))
            finish()
        }, 3000L)

        DatabaseUtil.getInstance(applicationContext)

    }
}