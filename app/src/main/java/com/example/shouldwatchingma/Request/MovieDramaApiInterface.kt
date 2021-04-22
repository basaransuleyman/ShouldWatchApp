package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieDramaApiInterface {
    @GET("/3/discover/movie?with_genres=18&api_key=b7df66246a2824e1ef415bffd34c5626")
    fun  getMovieListDrama(): Call<MovieResponse>

}