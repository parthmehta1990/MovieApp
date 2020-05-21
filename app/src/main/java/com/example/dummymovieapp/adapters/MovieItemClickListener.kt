package com.example.dummymovieapp.adapters

import android.widget.ImageView
import com.example.dummymovieapp.models.Movies

interface MovieItemClickListener {

    //Here we taking imageview to make the shared element transition
    //between two activity
    fun onMovieClick(movie: Movies, movieImage: ImageView)
}