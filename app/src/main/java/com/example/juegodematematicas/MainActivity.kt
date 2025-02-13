package com.example.juegodematematicas // Define el paquete.

import android.content.Intent // Importa Intent para navegar entre actividades.
import android.os.Bundle // Importa Bundle (no utilizado aquí).
import android.widget.Button // Importa Button.
import androidx.appcompat.app.AppCompatActivity // Importa AppCompatActivity.

class MainActivity : AppCompatActivity() { // Define la actividad principal.

    override fun onCreate(savedInstanceState: Bundle?) { // Método llamado al crear la actividad.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_principal) // Establece el layout de la actividad.

        val btnStart: Button = findViewById(R.id.btnStart) // Obtiene el botón desde el layout.

        btnStart.setOnClickListener { // Establece la acción al hacer clic en el botón.
            val intent = Intent(this, MenuActivity::class.java) // Crea un Intent para iniciar MenuActivity.
            startActivity(intent) // Inicia MenuActivity.
        }
    }
}
