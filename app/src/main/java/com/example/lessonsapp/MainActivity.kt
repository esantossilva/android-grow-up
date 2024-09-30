package com.example.lessonsapp

import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    var counter = 0
    lateinit var button: Button
    lateinit var userName: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var userNameLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.bLogin)
        userName = findViewById(R.id.tietUsername)
        password = findViewById(R.id.tietPassword)
        userNameLabel = findViewById(R.id.tvUserLabel)

        button.setOnClickListener {
            if (userName.text.toString() == "eduardo" && password.text.toString() == "growup")
                goToSongListScreen()
            else
                showMessage(this, "Erro ao fazer login")
        }
    }

    fun incrementButtonValue() {
        // quando clicar no botão, mudar o texto dele e adicionar 1
        button.text = if (counter == 1) "Clicou $counter vez"
        else "Clicou $counter vezes"
    }
}

fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}