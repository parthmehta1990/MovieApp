package com.example.dummymovieapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.dummymovieapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MovieDetailActivity : AppCompatActivity() {

    lateinit var title: String
    lateinit var description: String
    var imgURL: Int = 0
    lateinit var rating: String
    lateinit var streamingLink: String
    lateinit var studio: String
    var imgCoverPicData: Int = 0

    lateinit var imgPic:ImageView
    lateinit var imgCoverPic:ImageView
    lateinit var txtTitle:TextView
    lateinit var txtDesc:TextView
    lateinit var fab_Play:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        //getting the data from previous activity

        title = intent.extras?.getString("title").toString()
        description = intent.extras?.getString("description").toString()
        imgURL = intent.extras?.getInt("imgURL")!!
        rating = intent.extras?.getString("rating").toString()
        streamingLink = intent.extras?.getString("streaminglink").toString()
        studio = intent.extras?.getString("studio").toString()
        imgCoverPicData= intent.extras?.getInt("coverPic")!!

        viewInitialize()
        assignData()


    }

    fun viewInitialize(){
        imgPic=findViewById(R.id.detail_movie_img)
        imgCoverPic=findViewById(R.id.detail_movie_cover)
        txtTitle=findViewById(R.id.detail_movie_title)
        txtDesc=findViewById(R.id.detail_movie_desc)
        fab_Play=findViewById(R.id.detail_movie_fab_play)
    }

    fun assignData()
    {
        //imgPic.setImageResource(imgURL)
        Glide.with(this).load(imgURL).into(imgPic)

        Glide.with(this).load(imgCoverPicData).into(imgCoverPic)

        txtTitle.text=title

        imgCoverPic.animation=AnimationUtils.loadAnimation(this,R.anim.scale_animation)

        fab_Play.animation=AnimationUtils.loadAnimation(this,R.anim.scale_animation)

    }

}
