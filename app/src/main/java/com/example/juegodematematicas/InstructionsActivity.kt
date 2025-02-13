package com.example.juegodematematicas

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class InstructionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_instrucciones) // Establece el diseño de la actividad

        val btnBack: Button = findViewById(R.id.btnBack) // Obtiene el botón de regreso
        btnBack.setOnClickListener {
            finish() // Cierra la actividad actual y regresa a la actividad anterior
        }
    }
}
