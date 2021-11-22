package com.example.dionaro.inicio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.DialogFragment
import com.example.dionaro.R

class DialogoFragmentBusqueda(val listener : (flag : Boolean, texto : String) -> Unit) : DialogFragment(){
    private lateinit var botonCancelarDialog : Button
    private lateinit var botonBuscarDialof : Button
    private lateinit var inputTexto : EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.dialog_fragment_busqueda, container, false)
        botonCancelarDialog = vista.findViewById(R.id.buttonCancelar)
        botonCancelarDialog.setOnClickListener {
            dismiss()
        }
        botonBuscarDialof = vista.findViewById(R.id.buttonBuscar)
        botonBuscarDialof.setOnClickListener {
            regresoActividad()
        }
        inputTexto = vista.findViewById(R.id.inputBusquedaTexto)
        return vista
    }

    private fun regresoActividad(){
        listener(true,inputTexto.text.toString())
        dismiss()
    }

}