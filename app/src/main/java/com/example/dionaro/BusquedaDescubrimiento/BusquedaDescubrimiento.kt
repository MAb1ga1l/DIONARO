package com.example.dionaro.BusquedaDescubrimiento

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.dionaro.R

class BusquedaDescubrimiento : AppCompatActivity() {
    private lateinit var tituloTextoBuscado : TextView
    private lateinit var textoVideos : TextView
    private lateinit var textoDocs : TextView
    private var seccionBusqueda = "Videos"
    private var tipoBusqueda = "Palabra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda_descubrimiento)
        tituloTextoBuscado = findViewById(R.id.textViewTituloBusqueda)
        tituloTextoBuscado.text = intent.getStringExtra("Texto_Buscado")
        textoVideos = findViewById(R.id.textViewVideosBusqueda)
        textoDocs = findViewById(R.id.textViewDocsBusqueda)
        cambioFragment()
        ajusteColoresText()
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

    @Suppress("UNUSED_PARAMETER")
    fun cambioVideos(view: View){
        seccionBusqueda = "Videos"
        cambioFragment()
    }
    fun cambioDocs(view: View){
        seccionBusqueda = "Docs"
        cambioFragment()
    }

    private fun cambioFragment() {
        val texto = intent.getStringExtra("Texto_Buscado")
        val fragmentoTarjetas = listaTarjetasBusqueda.newInstance(texto.toString(),seccionBusqueda,tipoBusqueda)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewBusqueda, fragmentoTarjetas).commit()
        ajusteColoresText()
    }

    private fun ajusteColoresText(){
        when (seccionBusqueda) {
            "Videos" -> {
                textoVideos.setTextColor(Color.parseColor("#4e93e6"))
                textoDocs.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
            else -> {
                textoVideos.setTextColor(Color.parseColor("#FFFFFFFF"))
                textoDocs.setTextColor(Color.parseColor("#4e93e6"))
            }
        }
    }
}