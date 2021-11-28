package com.example.dionaro.informacion

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.format.DateFormat
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*


class Informacion : AppCompatActivity() {
    private lateinit var tituloMaterial : TextView
    private lateinit var botonFavoritos: ImageButton
    private lateinit var botonAvance: ImageButton
    private var idMaterial : String = ""
    private var tipoMaterial : String = ""
    private val db = FirebaseFirestore.getInstance()
    private var flagGuardadoEnFav : Boolean = false
    private var flagGuardadoEnavance : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacion)
        tituloMaterial = findViewById(R.id.textViewTituloMaterial)
        botonFavoritos = findViewById(R.id.botonInicioFavoritos)
        botonAvance = findViewById(R.id.botonAvancesMaterial)
        flagGuardadoFavoritos()
        flagGuardadoAvance()
        tipoMaterial = intent.getStringExtra("tipoMaterial").toString()
        tituloMaterial.text = intent.getStringExtra("tituloM").toString()
        idMaterial = intent.getStringExtra("idMaterial").toString()
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

    private fun flagGuardadoFavoritos(){
        botonFavoritos.setColorFilter(Color.parseColor("#4e93e6"))
        db.collection("favoritos").get().addOnSuccessListener {
                resultado ->
            if(resultado != null){
                for(notas in resultado){
                    if (notas.id == idMaterial){
                        botonFavoritos.setColorFilter(Color.parseColor("#FFFFFFFF"))
                        flagGuardadoEnFav = true
                    }
                }
            }
        }
    }

    private fun flagGuardadoAvance(){
        botonAvance.setColorFilter(Color.parseColor("#4e93e6"))
        db.collection("avances").get().addOnSuccessListener {
                resultado ->
            if(resultado != null){
                for(notas in resultado){
                    if (notas.id == idMaterial){
                        botonAvance.setColorFilter(Color.parseColor("#FFFFFFFF"))
                        flagGuardadoEnavance = true
                    }
                }
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun guardarEliminarFavoritos(view: View){
        if(flagGuardadoEnFav){
            //se quita el guardado de favoritos
            botonFavoritos.setColorFilter(Color.parseColor("#4e93e6"))
            db.collection("favoritos").document(idMaterial).delete()
            flagGuardadoEnFav = false
        }else{
            //se guarda en favoritos
            botonFavoritos.setColorFilter(Color.parseColor("#FFFFFFFF"))
            flagGuardadoEnFav = true
            val fechaactual = Date()
            db.collection("favoritos").document(idMaterial).set(
                hashMapOf(
                    "fecha" to ajusteFecha(fechaactual),
                    "tipoMaterial" to tipoMaterial
                )
            )
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun guardarEliminarAvance(view: View){
        if(flagGuardadoEnavance){
            //se quita el guardado de los avances
            botonAvance.setColorFilter(Color.parseColor("#4e93e6"))
            db.collection("avances").document(idMaterial).delete()
            flagGuardadoEnavance = false
        }else{
            //se guarda en avances
            botonAvance.setColorFilter(Color.parseColor("#FFFFFFFF"))
            flagGuardadoEnavance = true
            val fechaactual = Date()
            db.collection("avances").document(idMaterial).set(
                hashMapOf(
                    "fecha" to ajusteFecha(fechaactual),
                    "tipoMaterial" to tipoMaterial,
                    "progreso" to "0"
                )
            )
        }
    }

    private fun ajusteFecha(fecha : Date) : String {
        val day = DateFormat.format("dd", fecha) as String
        val mes = DateFormat.format("MM", fecha) as String
        val anio = DateFormat.format("yyyy", fecha) as String
        return day.plus(" / ").plus(mes).plus(" / ").plus(anio)
    }
}