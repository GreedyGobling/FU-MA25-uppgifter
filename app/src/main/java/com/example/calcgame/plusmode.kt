package com.example.calcgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class plusmode : AppCompatActivity() {

    lateinit var questionTextView: TextView
    lateinit var answerEditText: EditText
    var correctAnswer: Int = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plusmode)

        questionTextView = findViewById(R.id.question)
        answerEditText = findViewById(R.id.guess)

        // Get initial score from intent
        score = intent.getIntExtra("score", 0)

        setquestion()

        val button = findViewById<TextView>(R.id.answerbutton)
        button.setOnClickListener {
            handleanswer()
        }

        val leave = findViewById<Button>(R.id.leave)
        leave.setOnClickListener {
            val result = Intent()
            result.putExtra("score", score)
            setResult(RESULT_OK, result)
            finish()
        }
    }
    fun handleanswer() {
        val isCorrect = checkAnswer()
        if (isCorrect) {
            questionTextView.text = "Correct! "
            Log.d("MainActivity", "User answered correctly.")
            score++
            setquestion()
        } else {
            questionTextView.text = "Incorrect. The correct answer was $correctAnswer."
            Log.d("MainActivity", "User answered incorrectly.")
        }
        answerEditText.text.clear()

    }

    fun checkAnswer (): Boolean {
        val userAnswer = answerEditText.text.toString().toIntOrNull()
        return userAnswer == correctAnswer
    }

    fun setquestion(){
        val num1 = (1..10).random()
        val num2 = (1..10).random()

        correctAnswer = num1 + num2

        questionTextView.text = "What is $num1 + $num2?"
    }
}