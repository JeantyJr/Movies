package com.example.movies.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.movies.data.dataSources.DataSources
import com.example.movies.data.model.MoviesResultResponse
import com.example.movies.data.repository.Repositories
import com.example.movies.databinding.ActivitySecondBinding
import com.example.movies.utiles.ApiConfiguration

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    private lateinit var moviesResultResponse: MoviesResultResponse
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView4.text = this.intent.extras?.get("overview").toString()
        binding.textView5.text = this.intent.extras?.get("release_date").toString()
        binding.textView6.text = this.intent.extras?.get("vote_average").toString()
        Glide.with(binding.imageView).load(this.intent.extras?.get("backdrop_path")).into(binding.imageView)
        Glide.with(binding.imageView3).load(this.intent.extras?.get("poster_path")).into(binding.imageView3)






    }
}