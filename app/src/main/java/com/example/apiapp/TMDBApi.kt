package com.example.apiapp

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TMDBApi {
    @GET("search/movie")
    suspend fun searchMovies(
        // the string/value inside @Quary most be written right/correct
        @Query("query")query: String,
        @Header("Authorization") apiKey:String
    ): SearchResponse

}