package com.example.dionaro.informacion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R


class Informacion : AppCompatActivity() {
    private lateinit var tituloMaterial : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        tituloMaterial = findViewById(R.id.textViewTituloMaterial)
        tituloMaterial.text = intent.getStringExtra("tipoMaterial")
    }

    companion object{
        fun nuevaInstancia(contexto : Context,idMaterial:String,tipoMaterial:String) : Intent {
            return Intent(contexto, Informacion::class.java).apply {
                //Aquí se recibira
                putExtra("idMaterial",idMaterial)
                putExtra("tipoMaterial",tipoMaterial)
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun regresarInicio(view: View){
        val accion = "RegresoHome"
        val datos = intent.apply {
            putExtra("Accion",accion)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }
}