package com.example.apiapp

import com.google.gson.annotations.SerializedName

data class Movie (
    val id:Int,
    val title:String,
    @SerializedName("overview")val des:String,
    @SerializedName("poster_path")val posterPath:String
)

