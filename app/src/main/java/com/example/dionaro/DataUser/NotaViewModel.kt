package com.example.dionaro.DataUser

import android.content.Context
import android.os.Environment
import androidx.lifecycle.ViewModel
import java.io.File

class NotaViewModel :ViewModel() {
    val notasRegistradas = mutableListOf<Nota>()

    fun agregaNota(nuevaNota: Nota) {
        notasRegistradas.add(nuevaNota)
    }

    fun eliminarNota(posicion : Int){
        notasRegistradas.removeAt(posicion)
    }

}