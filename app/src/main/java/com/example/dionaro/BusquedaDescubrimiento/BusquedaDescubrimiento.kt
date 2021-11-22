package com.example.dionaro.BusquedaDescubrimiento

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.dionaro.R

class BusquedaDescubrimiento : AppCompatActivity() {
    private lateinit var tituloTextoBuscado : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda_descubrimiento)
        tituloTextoBuscado = findViewById(R.id.textViewTituloBusqueda)
        tituloTextoBuscado.text = intent.getStringExtra("Texto_Buscado")
    }

    companion object {
        fun nuevaInstancia (contexto: Context,texto : String) : Intent {
            //De forma general aquí se le va dar el intento a quien busque ejecutarlo
            return Intent(contexto, BusquedaDescubrimiento::class.java).apply {
                //aquí encontraremos el texto a buscar
                putExtra("Texto_Buscado", texto)
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