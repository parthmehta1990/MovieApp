package com.example.dummymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList
import android.graphics.Movie
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var movieSliderData: ArrayList<Slide>
    lateinit var slidePager: ViewPager
    lateinit var indicator: TabLayout
    lateinit var movieRV:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSliderData()
        createSlideBanner()
        createMovieData()

    }

    private fun createMovieData() {
        var lstMovies: ArrayList<Movies>
        lstMovies= ArrayList()

        lstMovies.add(Movies("Moana", thumbnail= R.drawable.moana))
        lstMovies.add(Movies("Black P", thumbnail= R.drawable.blackp))
        lstMovies.add(Movies("The Martian",thumbnail= R.drawable.themartian))
        lstMovies.add(Movies("The Martian",thumbnail= R.drawable.themartian))
        lstMovies.add(Movies("The Martian", thumbnail= R.drawable.themartian))
        lstMovies.add(Movies("The Martian",thumbnail= R.drawable.themartian))

        movieRV=findViewById(R.id.Rv_movies)

        var movieAdapter:MovieAdapter= MovieAdapter(this,lstMovies)
        movieRV.adapter=movieAdapter

        movieRV.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)

    }

    fun createSliderData() {
        //Initialize the slider data variable
        movieSliderData = ArrayList()

        movieSliderData.add(Slide(R.drawable.slide1, "X-Man"))
        movieSliderData.add(Slide(R.drawable.slide2, "Harry Potter"))
        movieSliderData.add(Slide(R.drawable.spidercover, "Spider Man"))
        movieSliderData.add(Slide(R.drawable.slide1, "X-Man"))
        movieSliderData.add(Slide(R.drawable.slide2, "Harry Potter"))
        movieSliderData.add(Slide(R.drawable.spidercover, "Spider Man"))

    }

    fun createSlideBanner() {
        slidePager = findViewById(R.id.slider_pager)
        indicator = findViewById(R.id.indicator)

        var sliderPageAdapter = SliderPageAdapter(this, movieSliderData)
        slidePager.adapter = sliderPageAdapter

        var timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(), 4000, 6000)

        indicator.setupWithViewPager(slidePager, true)
    }

    internal inner class SliderTimer : TimerTask() {


        override fun run() {

            this@MainActivity.runOnUiThread(Runnable {
                if (slidePager.currentItem < movieSliderData.size - 1) {
                    slidePager.currentItem = slidePager.currentItem + 1
                } else
                    slidePager.currentItem = 0
            })


        }
    }
}
