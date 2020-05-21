package com.example.dummymovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dummymovieapp.R
import com.example.dummymovieapp.models.Movies

class MovieAdapter(
    var context: Context,
    var mData: ArrayList<Movies>,
    ClickListener: MovieItemClickListener
) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    var ctx: Context
    var mMovieData: ArrayList<Movies>

    var movieItemClickListener: MovieItemClickListener

    init {
        ctx = context
        mMovieData = ArrayList()
        mMovieData = mData
        this.movieItemClickListener = ClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view: View = LayoutInflater.from(ctx).inflate(R.layout.item_movie, parent, false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mMovieData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.TvTitle.text = mMovieData[position].title
        holder.imgMovie.setImageResource(mMovieData[position].thumbnail)

        holder.bind(mMovieData[position], movieItemClickListener)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movies: Movies, movieItemClickListener: MovieItemClickListener) {
            itemView.setOnClickListener(View.OnClickListener {
                movieItemClickListener.onMovieClick(movies,imgMovie)
            })
        }

        var TvTitle: TextView
        var imgMovie: ImageView

        init {
            TvTitle = itemView.findViewById(R.id.item_movie_title)
            imgMovie = itemView.findViewById(R.id.item_movie_img)

        }

    }

}