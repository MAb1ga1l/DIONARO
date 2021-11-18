package com.example.dionaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.dionaro.AvanceFavoritos.AvancesFavoritos
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
        if (actividad != null) {
            cambioActividad(actividad)
        }
    }
    private var ejecutarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta ->
        val datos : Intent? = respuesta.data
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

    fun cambioActividad(actividad:String){
        if (actividad=="Recordatorios"){
            val intento = Recordatorios.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Notas"){
            val intento = Notas.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Favoritos"){
            val intento = AvancesFavoritos.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
        if (actividad=="Perfil"){
            val intento = Perfil.nuevaInstancia(this)
            ejecutarActividad.launch(intento)
        }
    }

}