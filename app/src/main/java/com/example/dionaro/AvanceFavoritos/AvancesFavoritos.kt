package com.example.dionaro.AvanceFavoritos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.DataMaterial.Articulos
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.R

class AvancesFavoritos : AppCompatActivity() , ListaMateriales.InterfazMateriales{
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

    override fun videoSeleccionado(video: Videos) {
        val accion = "Material"
        val datos = intent.apply {
            putExtra("Accion",accion)
            putExtra("idData",video.idVideo)
            putExtra("tituloM",video.nombreVideo)
            putExtra("tipoMaterial","Video")
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    override fun docSeleccionado(doc: Articulos) {
        val accion = "Material"
        val datos = intent.apply {
            putExtra("Accion",accion)
            putExtra("idData",doc.idArticulo)
            putExtra("tituloM",doc.nombreArticulo)
            putExtra("tipoMaterial","Docs")
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }
}