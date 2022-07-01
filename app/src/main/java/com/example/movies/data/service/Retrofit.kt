package com.example.movies.data.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.movies.utiles.ApiConfiguration

object Retrofit {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiConfiguration.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

//

}