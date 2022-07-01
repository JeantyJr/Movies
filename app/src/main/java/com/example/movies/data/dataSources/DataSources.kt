package com.example.movies.data.dataSources


import com.example.movies.data.model.MovieResponse
import com.example.movies.data.model.MoviesResultResponse
import com.example.movies.data.service.ApiService
import com.example.movies.data.service.Retrofit
import com.example.movies.utiles.ApiConfiguration
import retrofit2.Response
import retrofit2.create
import retrofit2.http.Path


class DataSources(
    private val apiService: ApiService =
        Retrofit.getRetrofit().create(ApiService::class.java))

//
{
    suspend fun getPopularMovies(): Response<MovieResponse<List<MoviesResultResponse>>> {
      return apiService.getPopularMovies((ApiConfiguration.API_KEY))
    }

//

}