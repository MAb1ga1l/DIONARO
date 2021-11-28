package com.example.dionaro.DataUser

import androidx.lifecycle.ViewModel

class FavoritosViewModel : ViewModel(){
    val favoritosRegistrados = mutableListOf<Favoritos>()

    fun agregaNota(nuevoMaterial : Favoritos) {
        favoritosRegistrados.add(nuevoMaterial)
    }
}