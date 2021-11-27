package com.example.dionaro.BusquedaDescubrimiento

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.TextView
import android.widget.Toast
import com.example.dionaro.DataMaterial.Articulos
import com.example.dionaro.DataMaterial.Videos
import com.example.dionaro.R

class BusquedaDescubrimiento : AppCompatActivity() , listaTarjetasBusqueda.InterfazMateriales{
    private lateinit var tituloTextoBuscado : TextView
    private lateinit var textoVideos : TextView
    private lateinit var textoDocs : TextView
    private lateinit var busqueda : SearchView
    private var seccionBusqueda = "Videos"
    private var tipoBusqueda = "Palabra"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busqueda_descubrimiento)
        busqueda = findViewById(R.id.searchViewBusqueda)
        tituloTextoBuscado = findViewById(R.id.textViewTituloBusqueda)
        busqueda.setOnQueryTextListener(object  : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                busqueda.clearFocus()
                tituloTextoBuscado.text = query
                tipoBusqueda = "Palabra"
                cambioFragment()
                ajusteColoresText()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
        tituloTextoBuscado.text = intent.getStringExtra("Texto_Buscado")
        tipoBusqueda = intent.getStringExtra("TipoBusqueda").toString()
        textoVideos = findViewById(R.id.textViewVideosBusqueda)
        textoDocs = findViewById(R.id.textViewDocsBusqueda)
        cambioFragment()
        ajusteColoresText()
    }

    companion object {
        fun nuevaInstancia (contexto: Context,texto : String,tipoBusqueda:String) : Intent {
            //De forma general aquí se le va dar el intento a quien busque ejecutarlo
            return Intent(contexto, BusquedaDescubrimiento::class.java).apply {
                //aquí encontraremos el texto a buscar
                putExtra("Texto_Buscado", texto)
                putExtra("TipoBusqueda", tipoBusqueda)
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

    @Suppress("UNUSED_PARAMETER")
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
        //Toast.makeText(this, "${video.nombreVideo}", Toast.LENGTH_SHORT).show()
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
        //Toast.makeText(this, "${doc.nombreArticulo}", Toast.LENGTH_SHORT).show()
    }
}