package com.example.task08guiloginyregistro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class LoginActivity : AppCompatActivity() {


    private lateinit var Username : EditText
    private lateinit var Password : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnForgotPassword : Button
    private lateinit var btnLoginGoogle : Button
    private lateinit var btnLoginFacebook : Button
    private lateinit var btnSingIn : Button

    private lateinit var username :String
    private lateinit var password :String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Username = findViewById(R.id.editTextUsername)
        Password = findViewById(R.id.editTextPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLoginGoogle = findViewById(R.id.btnLoginGoogle)
        btnLoginFacebook = findViewById(R.id.btnLoginFacebook)
        btnForgotPassword = findViewById(R.id.btnForgotPassword)
        btnSingIn = findViewById(R.id.btnSingIn)
    }
}