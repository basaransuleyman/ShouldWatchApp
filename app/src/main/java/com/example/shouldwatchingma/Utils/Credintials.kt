package com.example.shouldwatchingma.Utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Credintials {

        companion object {
            private const  val baseUrl: String = "https://api.themoviedb.org"
            private var retrofit : Retrofit? = null
            fun getInstance() : Retrofit{
                if(retrofit==null){
                    retrofit = Retrofit.Builder()
                        .baseUrl(baseUrl)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
                return  retrofit!!
            }
        }

    }
