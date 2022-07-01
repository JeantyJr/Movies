package com.example.movies.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.movies.data.dataSources.DataSources
import com.example.movies.data.model.MovieResponse
import com.example.movies.data.model.MoviesResultResponse
import com.example.movies.data.repository.Repositories
import com.example.movies.data.service.ApiService
import com.example.movies.databinding.ActivityMainBinding
import com.example.movies.utiles.ApiConfiguration

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var adapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MoviesViewModel(Repositories(DataSources()))

        viewModel.moviesResultResponse()

        viewModel.moviesResult.observe(this){
            moviesRecycler(it)



            adapter.onItemClick = { moviesResultResponse ->

                val intent = Intent(this, SecondActivity::class.java).apply {
                    putExtra("overview", moviesResultResponse.overview)
                    putExtra("release_date", moviesResultResponse.releaseDate.replace("${moviesResultResponse.releaseDate}", "Year: ${moviesResultResponse.releaseDate}"))
                    putExtra("vote_average", moviesResultResponse.voteAverage.replace("${moviesResultResponse.voteAverage}", "Note: ${moviesResultResponse.voteAverage}"))
                    putExtra("backdrop_path", moviesResultResponse.backdropPath.replace("${moviesResultResponse.backdropPath}", "${ApiConfiguration.IMAGE_BASE_URL}${moviesResultResponse.backdropPath}"))
                    putExtra("poster_path", moviesResultResponse.posterPath.replace("${moviesResultResponse.posterPath}", "${ApiConfiguration.IMAGE_BASE_URL_DOS}${moviesResultResponse.posterPath}"))


                }
                startActivity(intent)
             }

        }







    }




    private fun moviesRecycler(list: List<MoviesResultResponse>) {
        adapter = MoviesAdapter(list, this.applicationContext)
        binding.recyviewMovie.adapter =adapter

    }
}