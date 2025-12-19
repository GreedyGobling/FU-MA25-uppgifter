package com.example.apiapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    // if url ends with / then don't att / to the url value if no / in the end then add / to all the value
    // "https://api.themoviedb.org/3/" = "search/movie" if end with /
    // "https://api.themoviedb.org/3" = "/search/movie" if don't end with /
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    val api: TMDBApi by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(
            TMDBApi::class.java
        )
    }
}