package com.example.newsapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler(Looper.getMainLooper())
            .postDelayed({
                goToHomePageActivity()
            },2000)
    }

    private fun goToHomePageActivity() {
        val intent= Intent(this,HomePage::class.java)
        startActivity(intent)
        finish()
    }

}