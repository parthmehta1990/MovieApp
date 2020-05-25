package com.example.dummymovieapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dummymovieapp.R
import com.example.dummymovieapp.adapters.CastAdapter
import com.example.dummymovieapp.models.Cast
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
    lateinit var RvCast:RecyclerView

    lateinit var castData:ArrayList<Cast>
    lateinit var castAdapter:CastAdapter

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
        assignCastData()


    }

    fun viewInitialize(){
        imgPic=findViewById(R.id.detail_movie_img)
        imgCoverPic=findViewById(R.id.detail_movie_cover)
        txtTitle=findViewById(R.id.detail_movie_title)
        txtDesc=findViewById(R.id.detail_movie_desc)
        fab_Play=findViewById(R.id.detail_movie_fab_play)

        RvCast=findViewById(R.id.rv_cast)


        fab_Play.setOnClickListener {

            var openvideoPlayer=Intent(this,MoviePlayerActivity::class.java)
            startActivity(openvideoPlayer)
        }
    }

    private fun assignData()
    {
        //imgPic.setImageResource(imgURL)
        Glide.with(this).load(imgURL).into(imgPic)

        Glide.with(this).load(imgCoverPicData).into(imgCoverPic)

        txtTitle.text=title

        imgCoverPic.animation=AnimationUtils.loadAnimation(this,R.anim.scale_animation)

        fab_Play.animation=AnimationUtils.loadAnimation(this,R.anim.scale_animation)

    }

    fun assignCastData(){

        castData= ArrayList()
        castData.add(Cast("cast One",R.drawable.cast_one))
        castData.add(Cast("cast Two",R.drawable.cast_two))
        castData.add(Cast("cast Three",R.drawable.cast_three))
        castData.add(Cast("cast Four",R.drawable.cast_four))
        castData.add(Cast("cast 5",R.drawable.cast_one))
        castData.add(Cast("cast 6",R.drawable.cast_two))
        castData.add(Cast("cast 7",R.drawable.cast_three))
        castData.add(Cast("cast 8",R.drawable.cast_four))

        castAdapter= CastAdapter(this,castData)
        RvCast.adapter=castAdapter

        RvCast.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

    }

}
