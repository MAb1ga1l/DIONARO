package com.example.dionaro.Descubrimiento

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dionaro.AvanceFavoritos.AvancesFavoritos
import com.example.dionaro.R

class Descubrimiento : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubrimiento)
    }
    companion object{
        fun nuevaInstancia(contexto : Context) : Intent {
            return Intent(contexto, Descubrimiento::class.java).apply {
                //Aquí se recibira
                //el titulo de la actividad en caso de entrar a la pantalla de favoritos o avances
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