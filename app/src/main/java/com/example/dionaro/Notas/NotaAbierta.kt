package com.example.dionaro.Notas

import android.annotation.SuppressLint
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
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

private const val ARG_PARAM3 = "idNota"
private const val ARG_PARAM1 = "tipoNota"

class NotaAbierta : AppCompatActivity() {

    //private lateinit var nota: Nota
    private val db = FirebaseFirestore.getInstance()
    private var idNota : String = ""
    private var tipoNota : String = ""
    private lateinit var titulo : EditText
    private lateinit var fecha : TextView
    private lateinit var texto : EditText
    private var mensaje = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nota_abierta)
        idNota = intent.getStringExtra(ARG_PARAM3).toString()
        tipoNota = intent.getStringExtra(ARG_PARAM1).toString()
        titulo = findViewById(R.id.editTextTituloNotaAbierta)
        fecha = findViewById(R.id.textViewFechaNotaAbierta)
        texto = findViewById(R.id.editTextInputNotaAbierta)
        if (tipoNota == "Seleccion"){
            buscarDataNota()
        }
    }

    companion object{
        fun nuevaInstancia(contexto : Context,idNota:String,tipoNota:String) : Intent {
            return Intent(contexto, NotaAbierta::class.java).apply {
                //Aquí se recibira el id de la Nota en caso de existir
                putExtra(ARG_PARAM1,tipoNota)
                putExtra(ARG_PARAM3,idNota)
            }
        }
    }

    @Suppress("UNUSED_PARAMETER")
    fun regresarNotas(view: View){
        guardarCambios()
        //Se regresa el mensaje de confirmación
        val datos = intent.apply {
            putExtra("Mensaje",mensaje)
        }
        setResult(Activity.RESULT_OK,datos)
        finish()
    }

    @Suppress("UNUSED_PARAMETER")
    fun menu(view: View){
        val dialogo = DialogoFragmentMenuOpcionesNotas { flag, texto ->
            if (flag){
                if(texto == "Eliminar nota"){
                    db.collection("notas").document(idNota).delete()
                    mensaje = "Nota Eliminada"
                    val datos = intent.apply {
                        putExtra("Mensaje",mensaje)
                    }
                    setResult(Activity.RESULT_OK,datos)
                    finish()
                }else{
                    Toast.makeText(this, "Para más hazte premium", Toast.LENGTH_SHORT).show()
                }
            }
        }
        dialogo.show(supportFragmentManager,"DialogoMenu")
    }

    fun buscarDataNota(){
        db.collection("notas").document(idNota).get().addOnSuccessListener {
            titulo.setText(it.get("titulo") as String?)
            texto.setText(it.get("textoEscrito") as String?)
        }
    }



    @SuppressLint("SetTextI18n")
    private fun guardarCambios() {
        if(TextUtils.isEmpty(titulo.text)){
            titulo.setText("Titulo Nota")
        }
        if(TextUtils.isEmpty(texto.text)){
            texto.setText("Faltan tus ideas")
        }
        db.collection("notas").document(idNota).set(
            hashMapOf(
                "titulo" to titulo.text.toString(),
                "fecha" to fecha.text.toString(),
                "textoEscrito" to texto.text.toString()
            )
        )
        mensaje = "Nota guardada correctamente"
    }
}