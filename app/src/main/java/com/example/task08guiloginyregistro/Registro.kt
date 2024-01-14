package com.example.task08guiloginyregistro

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        //CREACION DE LA VISTA
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

        //RECUPERACION DE LOS INTENTS
        val bundle= intent.extras
        var mail =bundle?.getString("mail")
        var password =bundle?.getString("contraseña")
        var provider = bundle?.getString("provider")


        //REGISTRO DEL USUARIO
        if (mail != null && password != null) {
            if (mail.isNotEmpty() && password.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(mail, password).addOnCompleteListener{
                        if (!it.isSuccessful){
                            val builder = AlertDialog.Builder(this)
                            builder.setTitle("Error")
                            builder.setMessage("Se ha producido un error en la autenticacion del ususario")
                            builder.setPositiveButton("Aceptar",null)
                            val dialog: AlertDialog = builder.create()
                            dialog.show()

                    }

            }
        }


        /*
        mail.text = email
        providerTextView.text = provider

        logOutButton.setOnClickListener{
            FirebaseAuth.getInstance().singOut()
            onBakPressed()*/
        }


    }

}
