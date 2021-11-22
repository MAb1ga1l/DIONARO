package com.example.dionaro

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.AvanceFavoritos.AvancesFavoritos
import com.example.dionaro.BusquedaDescubrimiento.BusquedaDescubrimiento
import com.example.dionaro.Descubrimiento.Descubrimiento
import com.example.dionaro.Notas.Notas
import com.example.dionaro.Perfil.Perfil
import com.example.dionaro.Recordatorios.Recordatorios
import com.example.dionaro.inicio.Inicio

class MainActivity : AppCompatActivity() {
    private val perfilCreado = true
    private var ejecutaInicio =registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta ->
        val datos : Intent? = respuesta.data
        val actividad = datos?.getStringExtra("Actividad")
        var textoExtra = datos?.getStringExtra("Data")
        if (textoExtra == null){
            textoExtra = ""
        }
        if (actividad != null) {
            cambioActividad(actividad,textoExtra)
        }
    }
    private var ejecutarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta ->
        val datos : Intent? = respuesta.data
        val accionARealizar = datos?.getStringExtra("Accion")
        cambioRegresoActividad(accionARealizar)
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

    private fun cambioActividad(actividad:String,textoExtra : String){
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
            val intento = BusquedaDescubrimiento.nuevaInstancia(this, textoExtra)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Descubre"){
            val intento = Descubrimiento.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
    }

    private fun cambioRegresoActividad(accionARealizar: String?) {
        if(accionARealizar == "RegresoHome"){
            val intento = Inicio.nuevaInstancia(this)
            ejecutaInicio.launch(intento)
        }
    }

}