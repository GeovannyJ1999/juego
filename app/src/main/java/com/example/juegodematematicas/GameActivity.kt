package com.example.juegodematematicas

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private var score = 0 // Puntuación del jugador
    private var incorrectAnswers = 0 // Respuestas incorrectas
    private var questionIndex = 0 // Índice de la pregunta actual
    private lateinit var txtQuestion: TextView // Campo de texto para mostrar la pregunta
    private lateinit var btnOption1: Button // Botón para la primera opción
    private lateinit var btnOption2: Button // Botón para la segunda opción
    private lateinit var mediaPlayer: MediaPlayer // Reproductor de sonido

    // Listas de preguntas para suma y resta
    private val sumQuestions = listOf(
        Question("¿Cuánto es 2 + 3?", 5, 4),
        Question("¿Cuánto es 6 + 4?", 10, 12),
        Question("¿Cuánto es 8 + 1?", 9, 7),
        Question("¿Cuánto es 5 + 7?", 12, 11),
        Question("¿Cuánto es 3 + 6?", 9, 8)
    )
    private val subQuestions = listOf(
        Question("¿Cuánto es 5 - 2?", 3, 4),
        Question("¿Cuánto es 10 - 6?", 4, 5),
        Question("¿Cuánto es 9 - 3?", 6, 7),
        Question("¿Cuánto es 8 - 5?", 3, 2),
        Question("¿Cuánto es 7 - 2?", 5, 6)
    )

    private lateinit var questions: List<Question> // Lista de preguntas seleccionada

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_juego)

        txtQuestion = findViewById(R.id.txtQuestion)
        btnOption1 = findViewById(R.id.btnOption1)
        btnOption2 = findViewById(R.id.btnOption2)

        // Obtener la operación seleccionada (suma o resta) y elegir las preguntas
        val operation = intent.getStringExtra("operation")
        questions = if (operation == "sum") sumQuestions.shuffled() else subQuestions.shuffled()

        loadQuestion() // Cargar la primera pregunta
    }

    private fun loadQuestion() {
        if (questionIndex < 5) {
            val question = questions[questionIndex]
            txtQuestion.text = question.text
            val options = listOf(question.correctAnswer, question.wrongAnswer).shuffled()
            btnOption1.text = options[0].toString()
            btnOption2.text = options[1].toString()

            // Verificar la respuesta cuando se selecciona una opción
            btnOption1.setOnClickListener { checkAnswer(btnOption1.text.toString().toInt(), question.correctAnswer) }
            btnOption2.setOnClickListener { checkAnswer(btnOption2.text.toString().toInt(), question.correctAnswer) }
        } else {
            endGame() // Finaliza el juego si ya se han respondido todas las preguntas
        }
    }

    private fun checkAnswer(selectedAnswer: Int, correctAnswer: Int) {
        // Incrementa la puntuación o las respuestas incorrectas según la respuesta seleccionada
        if (selectedAnswer == correctAnswer) {
            score++
        } else {
            incorrectAnswers++
        }
        questionIndex++ // Avanza al siguiente índice de pregunta
        loadQuestion() // Cargar la siguiente pregunta
    }

    private fun endGame() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score) // Pasar la puntuación al resultado
        intent.putExtra("incorrect", incorrectAnswers) // Pasar el número de respuestas incorrectas

        // Reproducir sonido dependiendo de si el jugador ganó o perdió
        mediaPlayer = if (score >= 3) {
            MediaPlayer.create(this, R.raw.win_sound) // Sonido de victoria
        } else {
            MediaPlayer.create(this, R.raw.lose_sound) // Sonido de derrota
        }
        mediaPlayer.start()

        startActivity(intent) // Iniciar la actividad de resultados
        finish() // Finalizar la actividad actual
    }
}

// Data class que representa una pregunta con su respuesta correcta e incorrecta
data class Question(val text: String, val correctAnswer: Int, val wrongAnswer: Int)
