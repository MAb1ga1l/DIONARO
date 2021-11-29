package com.example.dionaro.descubrimiento

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R

class Descubrimiento : AppCompatActivity() {

    private var seccionBusqueda = "Apps"
    private lateinit var textoApps : TextView
    private lateinit var textoCursos : TextView
    private lateinit var textoSoft : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubrimiento)
        val fragmentoTarjetas = ListaTarjetasDescubre.newInstance(seccionBusqueda)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerViewListaDescubrimiento, fragmentoTarjetas).commit()
        textoApps = findViewById(R.id.textViewAppsDescubre)
        textoCursos = findViewById(R.id.textViewVideosBusqueda)
        textoSoft = findViewById(R.id.textViewDocsBusqueda)
        ajusteColoresText()
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

    @Suppress("UNUSED_PARAMETER")
    fun cambioCursos(view: View){
        seccionBusqueda = "Cursos"
        cambioFragment()
    }
    @Suppress("UNUSED_PARAMETER")
    fun cambioApps(view: View){
        seccionBusqueda = "Apps"
        cambioFragment()
    }
    @Suppress("UNUSED_PARAMETER")
    fun cambioProgra(view: View){
        seccionBusqueda = "Soft"
        cambioFragment()
    }

    private fun cambioFragment(){
        val fragmentoTarjetas = ListaTarjetasDescubre.newInstance(seccionBusqueda)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerViewListaDescubrimiento, fragmentoTarjetas).commit()
        ajusteColoresText()
    }

    private fun ajusteColoresText(){
        when (seccionBusqueda) {
            "Apps" -> {
                textoApps.setTextColor(Color.parseColor("#4e93e6"))
                textoSoft.setTextColor(Color.parseColor("#FFFFFFFF"))
                textoCursos.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            "Cursos" -> {
                textoApps.setTextColor(Color.parseColor("#FFFFFFFF"))
                textoSoft.setTextColor(Color.parseColor("#FFFFFFFF"))
                textoCursos.setTextColor(Color.parseColor("#4e93e6"))
            }
            else -> {
                textoApps.setTextColor(Color.parseColor("#FFFFFFFF"))
                textoSoft.setTextColor(Color.parseColor("#4e93e6"))
                textoCursos.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
        }
    }
}