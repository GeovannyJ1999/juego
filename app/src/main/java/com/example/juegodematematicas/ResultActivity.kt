package com.example.juegodematematicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.resultado_de_actividad)

        val txtResult: TextView = findViewById(R.id.txtResult)
        val txtScore: TextView = findViewById(R.id.txtScore)
        val btnRestart: Button = findViewById(R.id.btnRestart)

        val score = intent.getIntExtra("score", 0)
        val incorrect = intent.getIntExtra("incorrect", 0)

        txtResult.text = if (score >= 3) "¡Ganaste!" else "Perdiste :("
        txtScore.text = "✅ Aciertos: $score\n❌ Errores: $incorrect"

        btnRestart.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}