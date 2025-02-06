package com.example.juegodematematicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_actividad)

        val btnSum: Button = findViewById(R.id.btnSum)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnInstructions: Button = findViewById(R.id.btnInstructions) // Asegurar que coincide con el XML

        btnSum.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("operation", "sum")
            startActivity(intent)
        }

        btnSub.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("operation", "sub")
            startActivity(intent)
        }

        btnInstructions.setOnClickListener {
            val intent = Intent(this, InstructionsActivity::class.java)
            startActivity(intent)
        }
    }
}