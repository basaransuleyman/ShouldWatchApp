package com.example.shouldwatchin.Request

import com.example.shouldwatchingma.Models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET

interface MovieSoonApiInterface {


        @GET("/3/movie/upcoming?api_key=b7df66246a2824e1ef415bffd34c5626")
        fun  getMovieListSoon(): Call<MovieResponse>

    }