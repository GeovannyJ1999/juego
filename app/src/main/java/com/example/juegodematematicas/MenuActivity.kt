package com.example.juegodematematicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_actividad) // Establece el diseño del menú

        val btnSum: Button = findViewById(R.id.btnSum) // Botón para la operación de suma
        val btnSub: Button = findViewById(R.id.btnSub) // Botón para la operación de resta
        val btnInstructions: Button = findViewById(R.id.btnInstructions) // Botón para ver las instrucciones

        // Iniciar juego con operaciones de suma
        btnSum.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("operation", "sum") // Pasa la operación de suma al siguiente Activity
            startActivity(intent)
        }

        // Iniciar juego con operaciones de resta
        btnSub.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("operation", "sub") // Pasa la operación de resta al siguiente Activity
            startActivity(intent)
        }

        // Iniciar la actividad de instrucciones
        btnInstructions.setOnClickListener {
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent) // Abre la pantalla de instrucciones
        }
    }
}
