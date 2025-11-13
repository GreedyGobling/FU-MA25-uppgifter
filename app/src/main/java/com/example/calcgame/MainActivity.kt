package com.example.calcgame

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var scoreView: TextView
    lateinit var scoreAmount: TextView

    var finalscore: Int = 0

    private val plusModeLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            finalscore = result.data?.getIntExtra("score", 0) ?: 0
            updateScore()
        }
    }

    private val minusModeLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            finalscore = result.data?.getIntExtra("score", 0) ?: 0
            updateScore()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreView = findViewById(R.id.score)
        scoreAmount = findViewById(R.id.scoreamount)
        updateScore()

        val posbutton = findViewById<Button>(R.id.pos)
        posbutton.setOnClickListener {
            val intent = Intent(this, PlusGameActivity::class.java)
            intent.putExtra("score", finalscore)
            plusModeLauncher.launch(intent)
        }

        val minusbutton = findViewById<Button>(R.id.minus)
        minusbutton.setOnClickListener {
            val intent = Intent(this, MinusGameActivity::class.java)
            intent.putExtra("score", finalscore)
            minusModeLauncher.launch(intent)
        }


    }

    fun updateScore(){
        if (finalscore == 0)
            scoreAmount.text = "None"
        else
            scoreAmount.text = finalscore.toString()
    }
}