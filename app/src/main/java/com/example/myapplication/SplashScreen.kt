package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import java.util.*

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        // Create a timer
        val timer = Timer()
        timer.schedule(object : TimerTask() {
            override fun run() {
                // Start the main activity after the timer is finished
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }
        }, 3000) // 3000ms = 3 seconds
    }
}
