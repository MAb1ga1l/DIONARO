package com.example.dionaro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val perfilCreado = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (perfilCreado){
            setContentView(R.layout.activity_inicio)
        }else{
            setContentView(R.layout.activity_login)
        }
    }

}