package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieDayApiInterface {

    @GET("/3/trending/movie/day?api_key=b7df66246a2824e1ef415bffd34c5626")
    fun  getMovieListDay(): Call<MovieResponse>

}