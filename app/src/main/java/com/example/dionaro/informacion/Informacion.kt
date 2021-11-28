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
        val tipoMaterial = intent.getStringExtra("tipoMaterial").toString()
        tituloMaterial.text = intent.getStringExtra("tituloM").toString()
        val idMaterial = intent.getStringExtra("idMaterial").toString()
        if(tipoMaterial == "Video"){
            val fragmento = FragmentoMostrarVideos.newInstance(idMaterial)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewInformacion, fragmento).commit()
        }else{
            val fragmento = FragmentoMostrarDocs.newInstance(idMaterial)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewInformacion, fragmento).commit()
        }
    }

    companion object{
        fun nuevaInstancia(contexto : Context,idMaterial:String,tipoMaterial:String,titulo:String) : Intent {
            return Intent(contexto, Informacion::class.java).apply {
                //Aquí se recibira
                putExtra("idMaterial",idMaterial)
                putExtra("tipoMaterial",tipoMaterial)
                putExtra("tituloM",titulo)
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
    fun redireccionNotas(unBoton: View){
        val accion = "Notas"
        val datos = intent.apply {
            putExtra("Accion",accion)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }
}