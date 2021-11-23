package com.example.dionaro.Notas

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R

class Notas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)
    }

    companion object{
        fun nuevaInstancia(contexto : Context) : Intent {
            return Intent(contexto, Notas::class.java).apply {
                //Aquí se recibira ...
            }
        }
    }

    //función para regresar a la pantalla de inicio
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