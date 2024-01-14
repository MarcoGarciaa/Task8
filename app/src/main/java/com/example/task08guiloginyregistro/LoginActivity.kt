package com.example.task08guiloginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {


    private lateinit var mail : EditText
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

        mail = findViewById(R.id.usuario)
        Password = findViewById(R.id.contraseña)
        btnLogin = findViewById(R.id.btnLogin)
        btnSingIn = findViewById(R.id.btnSingIn)

        btnLogin.setOnClickListener{
            if (mail.text.isNotEmpty() && Password.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(mail.text.toString(),
                        Password.text.toString()).addOnCompleteListener{
                            if (it.isSuccessful){
                                shiwHome(it.result?.user?.email?:"",ProviderType.BASIC)
                            } else {
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("Error")
                                builder.setMessage("Se ha producido un error en la autenticacion del ususario")
                                builder.setPositiveButton("Aceptar",null)
                                val dialog: AlertDialog = builder.create()
                                dialog.show()
                            }

                }

            }

        }
        btnSingIn.setOnClickListener(){
            if (mail.text.isNotEmpty() && Password.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .signInWithEmailAndPassword(mail.text.toString(),
                        Password.text.toString()).addOnCompleteListener{
                        if (it.isSuccessful){
                            shiwHome(it.result?.user?.email?:"",ProviderType.BASIC)
                        } else {
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("Error")
                            builder.setMessage("Se ha producido un error en la autenticacion del ususario")
                            builder.setPositiveButton("Aceptar",null)
                            val dialog: AlertDialog = builder.create()
                            dialog.show()
                        }

                    }

            }
        }


    }
    private fun shiwHome(email: String, provider: ProviderType ){
        val homeIntent = Intent(this,HomeActivity::class.java).apply{
            putExtra("email",email)
            putExtra("provider",provider.name)
        }
        startActivity(homeIntent)

    }

}