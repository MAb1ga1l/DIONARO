package com.example.dionaro.Notas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment
import com.example.dionaro.R

class DialogoFragmentMenuOpcionesNotas (val listener : (flag : Boolean, texto : String) -> Unit) : DialogFragment(){

    private lateinit var botonCancelarDialog : Button
    private lateinit var botonBuscarDialof : Button
    private lateinit var inputTexto : RadioGroup

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.dialog_fragment_menu_opciones_notas, container, false)
        inputTexto = vista.findViewById(R.id.gurpoTemas)
        botonCancelarDialog = vista.findViewById(R.id.buttonCancelarTemas)
        botonCancelarDialog.setOnClickListener {
            dismiss()
        }
        botonBuscarDialof = vista.findViewById(R.id.buttonBuscarTemas)
        botonBuscarDialof.setOnClickListener {
            val selectID = inputTexto.checkedRadioButtonId
            val radio = vista.findViewById<RadioButton>(selectID)
            regresoActividad(radio.text.toString())
        }
        return vista
    }

    private fun regresoActividad(tema : String){
        listener(true,tema)
        dismiss()
    }
}