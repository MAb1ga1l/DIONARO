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

class Notas : AppCompatActivity() {

    private var ejecutarActividad = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        respuesta->
        val datos : Intent? = respuesta.data
        val mensaje = datos?.getStringExtra("Mensaje")
        if (mensaje != null){
            val array = arrayListOf<Nota>()
            array.addAll(dataNotasViewModel.notasRegistradas)
            val fragmentoNotas =  ListaNotas.newInstance(array)
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
        val array = arrayListOf<Nota>()
        array.addAll(dataNotasViewModel.notasRegistradas)
        val fragmentoNotas =  ListaNotas.newInstance(array)
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
        val nuevaNota = Nota()
        dataNotasViewModel.agregaNota(nuevaNota)
        val intento = NotaAbierta.nuevaInstancia(this,nuevaNota)
        ejecutarActividad.launch(intento)
    }

}