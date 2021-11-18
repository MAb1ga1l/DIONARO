package com.example.dionaro.AvanceFavoritos

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dionaro.R
import com.example.dionaro.Recordatorios.Recordatorios

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