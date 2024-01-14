package com.example.task08guiloginyregistro

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

enum class ProviderType{
    BASIC
}

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {


    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
        val bundle= intent.extras
        val email =bundle?.getString("email")
        val provider = bundle?.getString("provider")

        /*
        mail.text = email
        providerTextView.text = provider

        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().singOut()
            onBakPressed()*/
        }


    }

}
