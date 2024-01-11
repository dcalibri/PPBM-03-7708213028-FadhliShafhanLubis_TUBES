package com.example.YTBoxing

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val enterNamaButton = findViewById<Button>(R.id.Login)
        enterNamaButton.setOnClickListener {

            val intent = Intent(this, EnterNamaActivity::class.java)
            startActivity(intent)
        }
    }


    }
