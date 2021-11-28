package com.example.dionaro.informacion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.fragment.app.DialogFragment
import com.example.dionaro.R

class DialogFragmentGuardaProgreso (val listener : (flag : Boolean, valorProgreso : String) -> Unit) : DialogFragment(),  SeekBar.OnSeekBarChangeListener{
    private lateinit var botonCancelarDialog : Button
    private lateinit var botonOkDialog : Button
    private lateinit var inputValor : SeekBar
    private var valor = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vista = inflater.inflate(R.layout.dialog_fragment_guarda_progreso, container, false)
        botonCancelarDialog = vista.findViewById(R.id.buttonCancelarProgreso)
        botonCancelarDialog.setOnClickListener {
            dismiss()
        }
        botonOkDialog = vista.findViewById(R.id.buttonOkProgreso)
        inputValor = vista.findViewById(R.id.seekBar)
        inputValor.setOnSeekBarChangeListener(this)
        botonOkDialog.setOnClickListener {
            listener(true, valor.toString())
            dismiss()
        }
        return vista
    }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
        valor = progress
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
    }
}