package com.example.dionaro.AvanceFavoritos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dionaro.R

class AvancesFavoritos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_avances_favoritos)
    }

    companion object{
        fun nuevaInstancia(contexto : Context) : Intent {
            return Intent(contexto, AvancesFavoritos::class.java).apply {
                //Aquí se recibira ...
            }
        }
    }
}