package com.example.shouldwatchingma.Request


import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieTopRatedApiInterface {

    @GET("/3/movie/top_rated?api_key=b7df66246a2824e1ef415bffd34c5626")
    fun  getMovieListTop():  Call<MovieResponse>

}
