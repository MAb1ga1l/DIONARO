package com.example.dionaro.dataUser

import androidx.lifecycle.ViewModel

class FavoritosViewModel : ViewModel(){
    val favoritosRegistrados = mutableListOf<Favoritos>()

    fun agregaNota(nuevoMaterial : Favoritos) {
        favoritosRegistrados.add(nuevoMaterial)
    }
}