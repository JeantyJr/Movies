package com.example.movies.data.repository

import com.example.movies.data.dataSources.DataSources

class Repositories(private val dataSources: DataSources) {
    suspend fun getPopularMovies() = dataSources.getPopularMovies()



 //   suspend fun getMoviesImages() = dataSources.getMoviesImages()
}