package com.example.calcgame

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.calcgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateScore()

        binding.pos.setOnClickListener {
            val intent = Intent(this, PlusGameActivity::class.java)
            intent.putExtra("score", finalscore)
            plusModeLauncher.launch(intent)
        }

        binding.minus.setOnClickListener {
            val intent = Intent(this, MinusGameActivity::class.java)
            intent.putExtra("score", finalscore)
            minusModeLauncher.launch(intent)
        }


    }

    fun updateScore(){
        if (finalscore == 0)
            binding.scoreamount.text = "None"
        else
            binding.scoreamount.text = finalscore.toString()
    }
}