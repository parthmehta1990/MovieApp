package com.example.dummymovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dummymovieapp.R
import com.example.dummymovieapp.models.Cast

class CastAdapter(var context: Context, var casts: ArrayList<Cast>) :
    RecyclerView.Adapter<CastAdapter.CastViewHolder>() {

    lateinit var ctx: Context
    lateinit var castList: ArrayList<Cast>

    init {
        ctx = context
        castList = ArrayList()
        castList = casts
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        var view: View = LayoutInflater.from(ctx).inflate(R.layout.item_cast, parent, false)

        return CastViewHolder(view)
    }

    override fun getItemCount(): Int {
        return castList.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {

        Glide.with(ctx).load(castList[position].img_link).into(holder.img)

    }

    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var img: ImageView
        lateinit var name: TextView

        init {
            img=itemView.findViewById(R.id.img_cast)
        }
    }

}