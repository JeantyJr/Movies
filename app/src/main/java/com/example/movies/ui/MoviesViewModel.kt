package com.example.movies.ui

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movies.data.model.MoviesResultResponse
import com.example.movies.data.repository.Repositories
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.load.engine.Resource
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MoviesViewModel (private val repositories: Repositories): ViewModel() {

 private   val _moviesList = MutableLiveData<List<MoviesResultResponse>>()
    val moviesResult: LiveData<List<MoviesResultResponse>> = _moviesList







    fun moviesResultResponse() {

      viewModelScope.launch {
          try {   val result = repositories.getPopularMovies()

              if (result.isSuccessful) {
                  _moviesList.value = result.body()?.result
              } else {
                  _moviesList.value = emptyList()
              }

          } catch (e: Exception){
             // Log.d("error Vm", "$e")
                _moviesList.value = emptyList()
              }

          }
      }
    }





