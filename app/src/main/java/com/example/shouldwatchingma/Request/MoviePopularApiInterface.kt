package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MoviePopularApiInterface {
    @GET("/3/movie/popular?api_key=b7df66246a2824e1ef415bffd34c5626")
    fun  getMovieListPopular(): Call<MovieResponse>

}