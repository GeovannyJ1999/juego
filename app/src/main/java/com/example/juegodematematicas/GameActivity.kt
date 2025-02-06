package com.example.juegodematematicas

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private var score = 0
    private var incorrectAnswers = 0
    private var questionIndex = 0
    private lateinit var txtQuestion: TextView
    private lateinit var btnOption1: Button
    private lateinit var btnOption2: Button

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

    private lateinit var questions: List<Question>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_juego)

        txtQuestion = findViewById(R.id.txtQuestion)
        btnOption1 = findViewById(R.id.btnOption1)
        btnOption2 = findViewById(R.id.btnOption2)

        val operation = intent.getStringExtra("operation")

        questions = if (operation == "sum") sumQuestions.shuffled() else subQuestions.shuffled()

        loadQuestion()
    }

    private fun loadQuestion() {
        if (questionIndex < 5) {
            val question = questions[questionIndex]
            txtQuestion.text = question.text
            val options = listOf(question.correctAnswer, question.wrongAnswer).shuffled()
            btnOption1.text = options[0].toString()
            btnOption2.text = options[1].toString()

            btnOption1.setOnClickListener { checkAnswer(btnOption1.text.toString().toInt(), question.correctAnswer) }
            btnOption2.setOnClickListener { checkAnswer(btnOption2.text.toString().toInt(), question.correctAnswer) }
        } else {
            endGame()
        }
    }

    private fun checkAnswer(selectedAnswer: Int, correctAnswer: Int) {
        if (selectedAnswer == correctAnswer) {
            score++
        } else {
            incorrectAnswers++
        }
        questionIndex++
        loadQuestion()
    }

    private fun endGame() {
        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("score", score)
        intent.putExtra("incorrect", incorrectAnswers)
        startActivity(intent)
        finish()
    }
}

data class Question(val text: String, val correctAnswer: Int, val wrongAnswer: Int)