package com.example.dionaro.DataUser

import androidx.lifecycle.ViewModel

class NotaViewModel :ViewModel() {
    val notasRegistradas = mutableListOf<Nota>()

    fun agregaNota(nuevaNota: Nota) {
        notasRegistradas.add(nuevaNota)
    }

}