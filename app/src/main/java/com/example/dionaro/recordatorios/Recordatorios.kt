package com.example.dionaro.recordatorios

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.dionaro.R

class Recordatorios : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)
    }

    companion object{
        fun nuevaInstancia(contexto : Context) : Intent{
            return Intent(contexto,Recordatorios::class.java).apply {
                //Aquí se recibira ...
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
    @Suppress("UNUSED_PARAMETER")
    fun mensajePremium(view: View){
        Toast.makeText(this, "Para más hazte premium", Toast.LENGTH_SHORT).show()
    }
}