package com.project.br.taskapp.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.project.br.taskapp.R

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        //Ocultar barra de status
        actionBar?.hide()
        setContentView(R.layout.activity_splash)


//        val r = Runnable {
//            startActivity(Intent(this, LoginActivity::class.java))
//            finish()
//        }
//
//        val h = Handler()
//        h.postDelayed(r, 5000)

        // Create a delay activity
        Handler().postDelayed(Runnable {
            startActivity(Intent(this,LoginActivity::class.java))
            finish()
        }, 4000)



    }
}