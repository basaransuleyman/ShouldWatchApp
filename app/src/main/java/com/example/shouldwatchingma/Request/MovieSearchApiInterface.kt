package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieSearchApiInterface {
    @GET("/3/search/movie?api_key=b7df66246a2824e1ef415bffd34c5626&query=")
    fun  getMovieListSearch(): Call<MovieResponse>

}