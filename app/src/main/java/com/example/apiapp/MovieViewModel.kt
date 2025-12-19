package com.example.apiapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MovieViewModel: ViewModel() {
    private val repository = MovieRepository()
    private val _movies= MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> = _movies

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun search(query:String){
        viewModelScope.launch {
            try {
                _movies.value = repository.searchMovie(query)
            } catch (e: Exception){
                _error.value = e.message
            }

        }
    }
}