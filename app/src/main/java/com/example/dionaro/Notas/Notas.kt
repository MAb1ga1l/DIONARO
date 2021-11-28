package com.example.dionaro.Notas

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.dionaro.DataUser.Nota
import com.example.dionaro.DataUser.NotaViewModel
import com.example.dionaro.R
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class Notas : AppCompatActivity() , ListaNotas.InterfazNotas{

    private val db = FirebaseFirestore.getInstance()
    private var ejecutarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta->
        val datos : Intent? = respuesta.data
        val mensaje = datos?.getStringExtra("Mensaje")
        if (mensaje != null){
            val fragmentoNotas =  ListaNotas.newInstance()
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewNotas, fragmentoNotas).commit()
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }
    }

    private val dataNotasViewModel : NotaViewModel by lazy {
        ViewModelProvider(this).get(NotaViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notas)
        val fragmentoNotas =  ListaNotas.newInstance()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerViewNotas, fragmentoNotas).commit()
    }

    companion object{
        fun nuevaInstancia(contexto : Context) : Intent {
            return Intent(contexto, Notas::class.java).apply {
                //Aquí se recibira ...
            }
        }
    }

    //función para regresar a la pantalla de inicio
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
    fun abrirNotaNueva(view: View){
        val idNota = UUID.randomUUID().toString().substring(0,6)
        db.collection("notas").document(idNota).set(
            hashMapOf(
                "titulo" to "",
                "fecha" to "",
                "textoEscrito" to ""
            )
        )
        val intento = NotaAbierta.nuevaInstancia(this,idNota,"Nueva")
        ejecutarActividad.launch(intento)
    }

    override fun idNotaSelecionado(id: String) {
        val intento = NotaAbierta.nuevaInstancia(this,id,"Seleccion")
        ejecutarActividad.launch(intento)
    }

}