package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieDocumentaryApiInterface {

    @GET("/3/discover/movie?with_genres=36,99&api_key=b7df66246a2824e1ef415bffd34c5626")
    fun  getMovieListDocumentary(): Call<MovieResponse>

}






