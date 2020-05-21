package com.example.dummymovieapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter (var context: Context, var mData:ArrayList<Movies>):RecyclerView.Adapter<MovieAdapter.MyViewHolder>()
{
    lateinit var ctx:Context
    lateinit var mMovieData:ArrayList<Movies>
    init {
        ctx=context
        mMovieData= ArrayList()
        mMovieData=mData
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var view:View=LayoutInflater.from(ctx).inflate(R.layout.item_movie,parent,false)

        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        return mMovieData.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.TvTitle.text=mMovieData[position].title
        holder.imgMovie.setImageResource(mMovieData[position].thumbnail)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var TvTitle:TextView
        lateinit var imgMovie:ImageView

        init {
            TvTitle=itemView.findViewById(R.id.item_movie_title)
            imgMovie=itemView.findViewById(R.id.item_movie_img)
        }

    }

}