package com.example.dionaro.inicio

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R

class Inicio : AppCompatActivity() {

    private var actividadRegreso = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
    }

    companion object {
        fun nuevaInstancia (contexto: Context) : Intent{
            //De forma general aquí se le va dar el intento a quien busque ejecutarlo
            return Intent(contexto, Inicio::class.java).apply {
                //aquí encontraremos la información del perfil que se inicio
            }
        }
    }

    fun redireccionRecordatorios(unBoton: View){
        actividadRegreso = "Recordatorios"
        val datos = intent.apply {
            putExtra("Actividad", actividadRegreso)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    fun redireccionNotas(unBoton: View){
        actividadRegreso = "Notas"
        val datos = intent.apply {
            putExtra("Actividad", actividadRegreso)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    fun redireccionFavoritos(unBoton: View){
        actividadRegreso = "Favoritos"
        val datos = intent.apply {
            putExtra("Actividad", actividadRegreso)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    fun redireccionPerfil(unBoton: View){
        actividadRegreso = "Perfil"
        val datos = intent.apply {
            putExtra("Actividad", actividadRegreso)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }


    fun busquedaPorTexto(unBoton: View){
        val dialog = DialogoFragmentBusqueda(){ flag, texto ->
            redireccionBusqueda(flag,texto)
        }
        dialog.show(supportFragmentManager, "DialogoBusqueda")
    }

    fun redireccionBusqueda(flag: Boolean, texto : String){
        if (flag){
            actividadRegreso = "Busqueda"
            val datos = intent.apply {
                putExtra("Actividad", actividadRegreso)
                putExtra("Data", texto)
            }
            setResult(Activity.RESULT_OK,datos)
            finish()
        }
    }


}