package com.example.dionaro.AvanceFavoritos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R

class AvancesFavoritos : AppCompatActivity() {
    private lateinit var tituloActividad : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avances_favoritos)
        tituloActividad = findViewById(R.id.textViewTituloAvancesFavoritos)
        tituloActividad.text = intent.getStringExtra("TituloActividad")
    }

    companion object{
        fun nuevaInstancia(contexto : Context,actividad:String) : Intent {
            return Intent(contexto, AvancesFavoritos::class.java).apply {
                //Aquí se recibira
                //el titulo de la actividad en caso de entrar a la pantalla de favoritos o avances
                putExtra("TituloActividad", actividad)
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