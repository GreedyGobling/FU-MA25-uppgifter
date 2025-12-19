package com.example.apiapp

import android.util.Log

class MovieRepository {

    private val api = RetrofitClient.api
    private val apiKey = "Bearer ${BuildConfig.TMDB_ACCESS_TOKEN}"

    suspend fun searchMovie(query: String) : List<Movie>{
        Log.i("SOUT", apiKey)
        return api.searchMovies(query, apiKey).results
    }
}