package com.example.movies.ui

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies.data.model.MoviesResultResponse
import com.example.movies.databinding.ItemmoviesBinding
import com.example.movies.utiles.ApiConfiguration


class MoviesAdapter(var list: List<MoviesResultResponse> = listOf(), val contex :Context): RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    var onItemClick : ((MoviesResultResponse) -> Unit)? = null

 //  private var list: List<MoviesResultResponse> = listOf()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
      return  MoviesViewHolder(ItemmoviesBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(this.list[position], contex)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(list[position])
        }
    }

    override fun getItemCount(): Int = this.list.size


   inner class MoviesViewHolder(private val binding: ItemmoviesBinding,) :
        RecyclerView.ViewHolder(binding.root) {

            fun bind(movies: MoviesResultResponse, contex: Context){
                val moviesUrl = "${ApiConfiguration.IMAGE_BASE_URL}${movies.posterPath}"
                binding.apply {
                    this.textView3.text = movies.originalTitle
                  Glide.with(contex).load(moviesUrl).into(imageView2)
                   // Glide.with(contex).load(moviesUrl).into(imageView2)


                }
            }
    }

}