@file:Suppress("unused")

package com.example.dionaro.dataUser

import androidx.lifecycle.ViewModel

class AvanceViewModel : ViewModel() {
    val avancesRegistrados = mutableListOf<Avance>()

    fun agregarAvance(nuevoMaterial : Avance) {
        avancesRegistrados.add(nuevoMaterial)
    }
}