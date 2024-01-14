package com.example.task08guiloginyregistro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.ads.mediationtestsuite.activities.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.example.task08guiloginyregistro.Registro


class LoginActivity : AppCompatActivity() {

    //VARIABLES
    private lateinit var mail : EditText
    private lateinit var Password : EditText
    private lateinit var btnLogin : Button
    private lateinit var btnForgotPassword : Button
    private lateinit var btnLoginGoogle : Button
    private lateinit var btnLoginFacebook : Button
    private lateinit var btnSingIn : Button
    private lateinit var username :String
    private lateinit var password :String

    //VARIABLE SISTEMA LOG
    private val TAG = "LoginActivity"

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "onCreate: La actividad está siendo creada")
        //CREACION DE LA VISTA

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //ASIGNACION DE VARIABLES CON ELEMENTOS LAYOUT
        Log.d(TAG, "ASIGNACION DE VARIABLES CON ELEMENTOS LAYOUT")
        mail = findViewById(R.id.usuario)
        Password = findViewById(R.id.contraseña)
        btnLogin = findViewById(R.id.btnLogin)
        btnSingIn = findViewById(R.id.btnSingIn)

        //FUNCION DEL BOTON LOGUEAR
        btnLogin.setOnClickListener{
            if (mail.text.isNotEmpty() && Password.text.isNotEmpty()){
                FirebaseAuth.getInstance()
                    .createUserWithEmailAndPassword(mail.text.toString(),
                        Password.text.toString()).addOnCompleteListener{
                            if (it.isSuccessful){
                                pasarIntents(mail.text.toString()?:"",Password.text.toString()?:"",ProviderType.BASIC)
                                //startActivity(InicioActivity)

                            } else {
                                val builder = AlertDialog.Builder(this)
                                builder.setTitle("Error")
                                builder.setMessage("Se ha producido un error en la autenticacion del ususario")
                                builder.setPositiveButton("Aceptar",null)
                                val dialog: AlertDialog = builder.create()
                                dialog.show()
                            }

                }

            }else{ }

        }

        //FUNCION DEL BOTON CREAR
        btnSingIn.setOnClickListener(){
            pasarIntents(mail.text.toString()?:"",Password.text.toString()?:"",ProviderType.BASIC)



        }


    }
    private fun pasarIntents(mail: String,contraseña: String, provider: ProviderType ){
        val registro = Intent(this,Registro::class.java).apply{
            putExtra("mail",mail)
            putExtra("contraseña",contraseña)
            putExtra("provider",provider.name)
        }
        startActivity(registro)


    }

}