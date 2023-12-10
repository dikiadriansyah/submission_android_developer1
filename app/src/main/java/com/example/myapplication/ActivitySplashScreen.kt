package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class ActivitySplashScreen : AppCompatActivity(){



    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen_activity)

        val background = object : Thread(){
            override fun run(){
                try {
                    Thread.sleep(3000)

                    val boxIntent = Intent(baseContext, MainActivity::class.java)
                    startActivity(boxIntent)
                } catch (e: Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()

    }
}