package com.example.juegodematematicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado_de_actividad) // Establece el diseño de resultados

        val txtResult: TextView = findViewById(R.id.txtResult) // Campo de texto para mostrar el resultado
        val txtScore: TextView = findViewById(R.id.txtScore) // Campo de texto para mostrar los aciertos y errores
        val btnRestart: Button = findViewById(R.id.btnRestart) // Botón para reiniciar el juego

        // Obtener la puntuación y los errores desde la actividad anterior
        val score = intent.getIntExtra("score", 0)
        val incorrect = intent.getIntExtra("incorrect", 0)

        // Mostrar mensaje de victoria o derrota según la puntuación
        txtResult.text = if (score >= 3) "¡Ganaste!" else "Perdiste :("
        txtScore.text = "✅ Aciertos: $score\n❌ Errores: $incorrect"

        // Iniciar un nuevo juego al presionar el botón de reiniciar
        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java) // Inicia la pantalla principal
            startActivity(intent)
            finish() // Cierra la actividad de resultados
        }
    }
}
