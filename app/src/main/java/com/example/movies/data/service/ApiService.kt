package com.example.movies.data.service

import com.example.movies.data.model.MovieResponse
import com.example.movies.data.model.MoviesImagesResponse
import com.example.movies.data.model.MoviesResultResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular?")
    suspend fun getPopularMovies(
        @Query("api_key") api_key:String
    ): Response<MovieResponse<List<MoviesResultResponse>>>


//    @GET("movie/{movie_id}/images?")
//    suspend fun getMoviesImages(
//        @Path("movie_id") movieId: Int,
//        @Query("api_key") api_key:String
//    ): Response<MovieResponse<List<MoviesImagesResponse>>>



}