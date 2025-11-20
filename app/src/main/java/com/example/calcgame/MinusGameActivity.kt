package com.example.calcgame

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.calcgame.databinding.ActivityGameModeBinding

class MinusGameActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGameModeBinding
    var correctAnswer: Int = 0
    var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameModeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get initial score from intent
        score = intent.getIntExtra("score", 0)

        setquestion()

        binding.answerbutton.setOnClickListener {
            handleanswer()
        }

        binding.leave.setOnClickListener {
            val result = Intent()
            result.putExtra("score", score)
            setResult(RESULT_OK, result)
            finish()
        }
    }

    fun handleanswer() {
        val isCorrect = checkAnswer()
        if (isCorrect) {
            binding.question.text = "Correct! "
            Log.d("MainActivity", "User answered correctly.")
            score++
            setquestion()
        } else {
            binding.question.text = "Incorrect. The correct answer was $correctAnswer."
            Log.d("MainActivity", "User answered incorrectly.")
        }
        binding.guess.text.clear()
    }

    fun checkAnswer(): Boolean {
        val userAnswer = binding.guess.text.toString().toIntOrNull()
        return userAnswer == correctAnswer
    }

    fun setquestion() {
        var num1 = (1..10).random()
        var num2 = (1..10).random()

        // Ensure num1 >= num2 to avoid negative answers
        if (num1 < num2) {
            val temp = num1
            num1 = num2
            num2 = temp
        }

        correctAnswer = num1 - num2

        binding.question.text = "What is $num1 - $num2?"
    }
}