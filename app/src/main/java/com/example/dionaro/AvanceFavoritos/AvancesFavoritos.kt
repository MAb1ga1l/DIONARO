package com.example.dionaro.AvanceFavoritos

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.DataMaterial.Articulos
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.R

class AvancesFavoritos : AppCompatActivity() , ListaMateriales.InterfazMaterialesFavoritos, ListaMaterialesAvance.InterfazMaterialesAvance{
    private lateinit var tituloActividad : TextView
    private var temaFiltrado : String = ""
    private var actividad: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avances_favoritos)
        tituloActividad = findViewById(R.id.textViewTituloAvancesFavoritos)
        actividad = intent.getStringExtra("TituloActividad").toString()
        tituloActividad.text = actividad
        val filtro = ""
        if(actividad=="Favoritos"){
            val fragmento = ListaMateriales.newInstance(temaFiltrado,filtro)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewFavAvances,fragmento).commit()
        }else{
            val fragmento = ListaMaterialesAvance.newInstance(temaFiltrado,filtro)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewFavAvances,fragmento).commit()
        }
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
    @Suppress("UNUSED_PARAMETER")
    fun menuOpciones(view: View){
        Toast.makeText(this, "Para más hazte premium", Toast.LENGTH_SHORT).show()
    }

    @Suppress("UNUSED_PARAMETER")
    fun filtrarPorTema(view: View){
        val tema = (view as Button).text
        var filtro = ""
        if (temaFiltrado == ""){
            //No hay nada filtrado y se guarda el tema directamente
            temaFiltrado = tema as String
            filtro = "Tema"
            Toast.makeText(this, "Filtrado por $tema", Toast.LENGTH_SHORT).show()
        }else{
            //Ya hay un tema seleccionado para filtrar
            if(tema.toString() == temaFiltrado){
                //Se quita la selección del tema
                temaFiltrado = ""
                Toast.makeText(this, "Sin filtro", Toast.LENGTH_SHORT).show()
            }else{
                //solo se cambio de Selección
                filtro = "Tema"
                temaFiltrado = tema as String
                Toast.makeText(this, "Filtrado por $tema", Toast.LENGTH_SHORT).show()
            }
        }
        if(actividad=="Favoritos"){
            val fragmento = ListaMateriales.newInstance(temaFiltrado,filtro)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewFavAvances,fragmento).commit()
        }else{
            val fragmento = ListaMaterialesAvance.newInstance(temaFiltrado,filtro)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewFavAvances,fragmento).commit()
        }
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