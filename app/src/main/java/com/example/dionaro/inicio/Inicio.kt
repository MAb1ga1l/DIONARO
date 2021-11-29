package com.example.dionaro.inicio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dionaro.DataMaterial.*
import com.example.dionaro.DataUser.Avance
import com.example.dionaro.DataUser.AvanceViewModel
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore

class Inicio : AppCompatActivity() {

    private var actividadRegreso = ""
    private var tipoDeBusqueda = ""
    private val dataAppViewModel : appsViewModel by lazy {
        ViewModelProvider(this).get(appsViewModel::class.java)
    }
    private val dataAViewModel : AvanceViewModel by lazy {
        ViewModelProvider(this).get(AvanceViewModel::class.java)
    }
    private val dataVViewModel : VideosViewModel by lazy {
        ViewModelProvider(this).get(VideosViewModel::class.java)
    }
    private val dataDViewModel : ArticulosViewModel by lazy {
        ViewModelProvider(this).get(ArticulosViewModel::class.java)
    }
    private var posicionDescubre : Int = 0
    private var posicionAvance : Int = 0
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        //val fragmentoTarjetaDescubre = supportFragmentManager.findFragmentById(R.id.fragmentContainerViewDescubre)
        val app = dataAppViewModel.appsRegitradas[posicionDescubre]
        val tarjetaDescubre = FragmentTarjetaDescubre.newInstance(app.nombre,app.linkFoto,app.descripcion,app.puntuacion)
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerViewDescubre, tarjetaDescubre).commit()
        db.collection("avances").get().addOnSuccessListener {
                resultado ->
            if(resultado != null){
                var videos: Videos
                var doc : Articulos
                for (av in resultado){
                    val nuevoAvance = Avance()
                    nuevoAvance.idMaterial = av.id
                    nuevoAvance.fecha = av.data["fecha"] as String
                    nuevoAvance.tipoMaterial = av.data["tipoMaterial"] as String
                    nuevoAvance.progreso = av.data["progreso"] as String
                    if(nuevoAvance.tipoMaterial == "Video"){
                        videos = buscarMaterialVideo(nuevoAvance.idMaterial)
                        nuevoAvance.nombreMaterial = videos.nombreVideo
                    }else{
                        doc = buscarMaterialDoc(nuevoAvance.idMaterial)
                        nuevoAvance.nombreMaterial = doc.nombreArticulo
                    }
                    dataAViewModel.agregarAvance(nuevoAvance)
                }
                val inventario =dataAViewModel.avancesRegistrados
                if(inventario.size > 0){
                    val material = inventario[posicionAvance]
                    val tarjetaProgreso = FragmentTarjetaProgreso.newInstance(material.nombreMaterial,material.tipoMaterial,material.progreso,material.fecha)
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerTarjetaProgresoInicio,tarjetaProgreso).commit()
                }else{
                    val tarjetaProgreso = FragmentoSinAvances()
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerTarjetaProgresoInicio,tarjetaProgreso).commit()
                }

            }else{
                val tarjetaProgreso = FragmentoSinAvances()
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerTarjetaProgresoInicio,tarjetaProgreso).commit()
            }
        }
    }

    companion object {
        fun nuevaInstancia (contexto: Context) : Intent{
            //De forma general aquí se le va dar el intento a quien busque ejecutarlo
            return Intent(contexto, Inicio::class.java).apply {
                //aquí encontraremos la información del perfil que se inicio
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionRecordatorios(unBoton: View){
        actividadRegreso = "Recordatorios"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionNotas(unBoton: View){
        actividadRegreso = "Notas"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionFavoritos(unBoton: View){
        actividadRegreso = "Favoritos"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionPerfil(unBoton: View){
        actividadRegreso = "Perfil"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun busquedaPorTexto(unBoton: View){
        val dialog = DialogoFragmentBusqueda { flag, texto ->
            redireccionBusqueda(flag,texto)
        }
        tipoDeBusqueda = "Palabra"
        dialog.show(supportFragmentManager, "DialogoBusqueda")
    }

    private fun buscarMaterialVideo(idMaterial : String): Videos{
        var video = Videos()
        val inventario = dataVViewModel.videosRegistrados
        for (material in inventario){
            if (material.idVideo == idMaterial){
                video = material
            }
        }
        return video
    }

    private fun buscarMaterialDoc(idMaterial : String): Articulos{
        var doc = Articulos()
        val inventario = dataDViewModel.articulosRegistrados
        for (material in inventario){
            if (material.idArticulo == idMaterial){
                doc = material
            }
        }
        return doc
    }

    private fun redireccionBusqueda(flag: Boolean, texto : String){
        if (flag){
            actividadRegreso = "Busqueda"
            val datos = intent.apply {
                putExtra("Actividad", actividadRegreso)
                putExtra("Data", texto)
                putExtra("TipoBusqueda", tipoDeBusqueda)
            }
            setResult(Activity.RESULT_OK,datos)
            finish()
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun busquedaPorTema(unBoton: View){
        val dialog = DialogoFragmentTemas { flag, texto ->
            redireccionBusqueda(flag,texto)
        }
        tipoDeBusqueda = "Tema"
        dialog.show(supportFragmentManager, "DialogoBusqueda")
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionDescubre(unBoton: View){
        actividadRegreso = "Descubre"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionAvance(unBoton: View){
        actividadRegreso = "Progreso"
        cambioActividad()
    }

    @Suppress("UNUSED_PARAMETER")
    fun redireccionMaterial(unBoton: View){
        actividadRegreso = "Material"
        if (dataAViewModel.avancesRegistrados.size > 0) {
            val material = dataAViewModel.avancesRegistrados[posicionAvance]
            val datos = intent.apply {
                putExtra("Actividad", actividadRegreso)
                putExtra("idData", material.idMaterial)
                putExtra("tituloM", material.nombreMaterial)
                putExtra("tipoMaterial", material.tipoMaterial)
            }
            setResult(Activity.RESULT_OK,datos)
            finish()
        }

    }

    private fun cambioActividad(){

        val datos = intent.apply {
            putExtra("Actividad", actividadRegreso)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    //Función para redireccionar a la plystore o a la página correspondiente
    @Suppress("UNUSED_PARAMETER")
    fun redireccionFueraApp(unBoton: View){
        val app = dataAppViewModel.appsRegitradas[posicionDescubre]
        val url = app.link
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    @Suppress("UNUSED_PARAMETER")
    fun cambioDataTarjetaDescubreDerecha(unBoton: View){
        if (posicionDescubre == -1){
            posicionDescubre =0
        }
        posicionDescubre += 1
        if(posicionDescubre <= 2){
            val app = dataAppViewModel.appsRegitradas[posicionDescubre]
            val tarjetaDescubre = FragmentTarjetaDescubre.newInstance(app.nombre,app.linkFoto,app.descripcion,app.puntuacion)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewDescubre, tarjetaDescubre).commit()
        }else{
            posicionDescubre=3
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun cambioDataTarjetaDescubreIzquierda(unBoton: View){
        if (posicionDescubre == 3){
            posicionDescubre = 2
        }
        posicionDescubre -= 1
        if(posicionDescubre >= 0){
            val app = dataAppViewModel.appsRegitradas[posicionDescubre]
            val tarjetaDescubre = FragmentTarjetaDescubre.newInstance(app.nombre,app.linkFoto,app.descripcion,app.puntuacion)
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewDescubre, tarjetaDescubre).commit()
        }else{
            posicionDescubre=-1
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun cambioDataTarjetaAvanceDerecha(unBoton: View){
        val max = dataAViewModel.avancesRegistrados.size - 1
        if (dataAViewModel.avancesRegistrados.size >0){
            if (posicionAvance == -1){
                posicionAvance =0
            }
            posicionAvance += 1
            if (posicionAvance > max){
                posicionAvance -= 1
            }
            if(posicionAvance <= 2){
                val material = dataAViewModel.avancesRegistrados[posicionAvance]
                val tarjetaProgreso = FragmentTarjetaProgreso.newInstance(material.nombreMaterial,material.tipoMaterial,material.progreso,material.fecha)
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerTarjetaProgresoInicio,tarjetaProgreso).commit()
            }else{
                posicionAvance=3
            }
        }

    }

    @Suppress("UNUSED_PARAMETER")
    fun cambioDataTarjetaAvanceIzquierda(unBoton: View){
        if (dataAViewModel.avancesRegistrados.size > 0) {
            if (posicionAvance == 3){
                posicionAvance = 2
            }
            posicionAvance -= 1
            if(posicionAvance >= 0){
                val material = dataAViewModel.avancesRegistrados[posicionAvance]
                val tarjetaProgreso = FragmentTarjetaProgreso.newInstance(material.nombreMaterial,material.tipoMaterial,material.progreso,material.fecha)
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerTarjetaProgresoInicio,tarjetaProgreso).commit()
            }else{
                posicionAvance=-1
            }
        }
    }
}