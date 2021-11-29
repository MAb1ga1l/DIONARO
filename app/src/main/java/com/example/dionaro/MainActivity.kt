package com.example.dionaro

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.avanceFavoritos.AvancesFavoritos
import com.example.dionaro.busquedaDescubrimiento.BusquedaDescubrimiento
import com.example.dionaro.descubrimiento.Descubrimiento
import com.example.dionaro.notas.Notas
import com.example.dionaro.perfil.Perfil
import com.example.dionaro.recordatorios.Recordatorios
import com.example.dionaro.informacion.Informacion
import com.example.dionaro.inicio.Inicio

class MainActivity : AppCompatActivity() {
    private val perfilCreado = true
    private var ejecutaInicio =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta ->
        val datos : Intent? = respuesta.data
        val actividad = datos?.getStringExtra("Actividad")
        var textoExtra = datos?.getStringExtra("Data")
        var tipoBusqueda = datos?.getStringExtra("TipoBusqueda")
        var idData = datos?.getStringExtra("idData")
        var titulo = datos?.getStringExtra("tituloM")
        var tipoMAterial = datos?.getStringExtra("tipoMaterial")
        if (textoExtra == null){
            textoExtra = ""
        }
        if (tipoBusqueda ==null){
            tipoBusqueda = ""
        }
        if (idData ==null){
            idData = ""
        }
        if (titulo ==null){
            titulo = ""
        }
        if (tipoMAterial ==null){
            tipoMAterial = ""
        }
        if (actividad != null) {
            cambioActividad(actividad,textoExtra,tipoBusqueda,idData,titulo,tipoMAterial)
        }
    }
    private var ejecutarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta ->
        val datos : Intent? = respuesta.data
        val accionARealizar = datos?.getStringExtra("Accion")
        var idData = datos?.getStringExtra("idData")
        var tipoMAterial = datos?.getStringExtra("tipoMaterial")
        var titulo = datos?.getStringExtra("tituloM")

        if (idData == null){
            idData = ""
        }
        if(tipoMAterial == null){
            tipoMAterial=""
        }
        if(titulo == null){
            titulo = ""
        }
        cambioRegresoActividad(accionARealizar,idData,tipoMAterial,titulo)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (perfilCreado){
            val intento = Inicio.nuevaInstancia(this)
            ejecutaInicio.launch(intento)
        }else{
            setContentView(R.layout.activity_login)
        }
    }

    private fun cambioActividad(
        actividad: String,
        textoExtra: String,
        tipoBusqueda: String,
        idData: String,
        titulo: String,
        tipoMAterial: String
    ){
        if (actividad=="Recordatorios"){
            val intento = Recordatorios.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Notas"){
            val intento = Notas.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Favoritos" || actividad=="Progreso"){
            val intento = AvancesFavoritos.nuevaInstancia(this,actividad)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Perfil"){
            val intento = Perfil.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Busqueda"){
            val intento = BusquedaDescubrimiento.nuevaInstancia(this, textoExtra,tipoBusqueda)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Descubre"){
            val intento = Descubrimiento.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Material"){
            val intento = Informacion.nuevaInstancia(this,idData,tipoMAterial,titulo)
            ejecutarActividad.launch(intento)
        }
    }

    private fun cambioRegresoActividad(
        accionARealizar: String?,
        idData: String,
        tipoMaterial: String,
        titulo: String
    ) {
        if(accionARealizar == "RegresoHome"){
            val intento = Inicio.nuevaInstancia(this)
            ejecutaInicio.launch(intento)
        }
        if (accionARealizar=="Material"){
            val intento = Informacion.nuevaInstancia(this,idData,tipoMaterial,titulo)
            ejecutarActividad.launch(intento)
        }
        if (accionARealizar=="Notas"){
            val intento = Notas.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
    }

}