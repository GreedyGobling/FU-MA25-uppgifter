package com.example.apiapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.apiapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var vm: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(MovieViewModel::class.java)

        vm.movie.observe(this){movies ->
            if(movies.isNotEmpty()){
                movies.forEach { movie -> Log.i("SOUT", movie.toString()) }
                binding.tvTitle.text = movies.first().title
                binding.tvDesc.text = movies.first().des

                movies.first().posterPath.let{ posterPath ->
                    val baseURL = "https://image.tmdb.org/t/p/w500"
                    Glide.with(this).load(baseURL+posterPath).into(binding.poster)
                }
            }
        }

        vm.error.observe(this){
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }
        binding.btnSearch.setOnClickListener {
            val query = binding.etQuery.text.toString()
            vm.search(query)
        }
    }
}