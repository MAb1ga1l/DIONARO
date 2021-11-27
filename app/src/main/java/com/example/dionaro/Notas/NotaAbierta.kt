package com.example.dionaro.Notas

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.dionaro.DataUser.Nota
import com.example.dionaro.DataUser.NotaViewModel
import com.example.dionaro.R

private const val ARG_PARAM1 = "idNota"
private const val ARG_PARAM2 = "Bundle"
class NotaAbierta : AppCompatActivity() {

    private lateinit var nota: Nota
    private lateinit var titulo : EditText
    private lateinit var fecha : TextView
    private lateinit var texto : EditText
    private var mensaje = ""
    private var idNota : String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_abierta)
        val bundle = intent.getBundleExtra(ARG_PARAM2)
        if (bundle != null) {
            nota = bundle.getParcelable<Nota>(ARG_PARAM1)!!
        }
        //nota = Nota()
        //nota = intent.getParcelableExtra<Nota>(ARG_PARAM1)!!
        //idNota = intent.getStringExtra(ARG_PARAM1).toString()
        titulo = findViewById(R.id.editTextTituloNotaAbierta)
        fecha = findViewById(R.id.textViewFechaNotaAbierta)
        texto = findViewById(R.id.editTextInputNotaAbierta)
        /*if (idNota == ""){
            //Se crea una nota nueva
            creaNota()
        }else{
            //se abre la nota solicitada
            retomarDataNota()
        }*/
    }

    companion object{
        fun nuevaInstancia(contexto : Context,nota: Nota) : Intent {
            val bundle = Bundle()
            return Intent(contexto, NotaAbierta::class.java).apply {
                //Aquí se recibira el id de la Nota en caso de existir
                bundle.putParcelable(ARG_PARAM1, nota)
                putExtra(ARG_PARAM2, bundle)
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun regresarNotas(view: View){
        //guardarCambio()
        //Se regresa el mensaje de confirmación
        val datos = intent.apply {
            putExtra("Mensaje",mensaje)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    //función para llenar la estructura de la nota
   /* private fun creaNota(){
        val nuevaNota = Nota()
        nota = nuevaNota
        notasViewModel.agregaNota(nuevaNota)
    }
    private fun retomarDataNota(){
        val inventario = notasViewModel.notasRegistradas
        for (notaEnInventario in inventario){
            if(notaEnInventario.idNota == idNota){
                titulo.setText(notaEnInventario.titulo)
                texto.setText(notaEnInventario.textoEscrito)
                nota = notaEnInventario
            }
        }
    }*/

    //función para gusrdar los cambios de la nota abierta
    /*fun guardarCambio(){
        nota.fecha = fecha.text as String
        if(TextUtils.isEmpty(texto.text)){
            nota.textoEscrito = "Faltan tus ideas"
        }else{
            nota.textoEscrito = texto.text.toString()
        }
        if(TextUtils.isEmpty(titulo.text)){
            nota.titulo = "Titulo de Nota"
        }else{
            nota.titulo = titulo.text.toString()
        }
        mensaje = "Nota guardada Correctamente"
    }*/
}