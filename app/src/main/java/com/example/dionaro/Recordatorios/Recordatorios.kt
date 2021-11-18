package com.example.dionaro.Recordatorios

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dionaro.R

class Recordatorios : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recordatorios)
    }

    companion object{
        fun nuevaInstancia(contexto : Context) : Intent{
            return Intent(contexto,Recordatorios::class.java).apply {
                //Aquí se recibira ...
            }
        }
    }
}