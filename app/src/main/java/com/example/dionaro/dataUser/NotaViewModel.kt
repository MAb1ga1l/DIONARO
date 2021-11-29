package com.example.dionaro.dataUser

import androidx.lifecycle.ViewModel

class NotaViewModel :ViewModel() {
    val notasRegistradas = mutableListOf<Nota>()

    fun agregaNota(nuevaNota: Nota) {
        notasRegistradas.add(nuevaNota)
    }

}