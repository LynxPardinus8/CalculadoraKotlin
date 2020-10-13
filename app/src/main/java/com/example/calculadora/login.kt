package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun Salir(view: View) {
        System.exit(0);
    }

    fun login(view: View) {
        var editTextUser = findViewById<EditText>(R.id.editTextUser)
        var user: String = editTextUser.text.toString()
        var miIntent = Intent(this, calc::class.java)
        miIntent.putExtra("user", user)
        startActivity(miIntent)
        finish()
    }
}