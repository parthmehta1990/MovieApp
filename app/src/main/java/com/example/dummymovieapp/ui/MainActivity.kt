package com.example.dummymovieapp.ui

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dummymovieapp.*
import com.example.dummymovieapp.adapters.MovieAdapter
import com.example.dummymovieapp.adapters.MovieItemClickListener
import com.example.dummymovieapp.adapters.SliderPageAdapter
import com.example.dummymovieapp.models.Movies
import com.example.dummymovieapp.models.Slide


class MainActivity : AppCompatActivity(),
    MovieItemClickListener {


    lateinit var movieSliderData: ArrayList<Slide>
    lateinit var slidePager: ViewPager
    lateinit var indicator: TabLayout
    lateinit var movieRV: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSliderData()
        createSlideBanner()
        createMovieData()

    }

    private fun createMovieData() {
        var lstMovies: ArrayList<Movies>
        lstMovies = ArrayList()

        lstMovies.add(
            Movies(
                "Moana",
                thumbnail = R.drawable.moana,
                coverPhoto = R.drawable.spidercover

            )
        )
        lstMovies.add(
            Movies(
                "Black P",
                thumbnail = R.drawable.blackp,
                coverPhoto = R.drawable.spidercover
            )
        )
        lstMovies.add(
            Movies(
                "The Martian",
                thumbnail = R.drawable.themartian
            )
        )
        lstMovies.add(
            Movies(
                "The Martian",
                thumbnail = R.drawable.themartian
            )
        )
        lstMovies.add(
            Movies(
                "The Martian",
                thumbnail = R.drawable.themartian
            )
        )
        lstMovies.add(
            Movies(
                "The Martian",
                thumbnail = R.drawable.themartian
            )
        )

        movieRV = findViewById(R.id.Rv_movies)

        var movieAdapter: MovieAdapter =
            MovieAdapter(this, lstMovies, this)
        movieRV.adapter = movieAdapter

        movieRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }

    fun createSliderData() {
        //Initialize the slider data variable
        movieSliderData = ArrayList()

        movieSliderData.add(
            Slide(
                R.drawable.slide1,
                "X-Man"
            )
        )
        movieSliderData.add(
            Slide(
                R.drawable.slide2,
                "Harry Potter"
            )
        )
        movieSliderData.add(
            Slide(
                R.drawable.spidercover,
                "Spider Man"
            )
        )
        movieSliderData.add(
            Slide(
                R.drawable.slide1,
                "X-Man"
            )
        )
        movieSliderData.add(
            Slide(
                R.drawable.slide2,
                "Harry Potter"
            )
        )
        movieSliderData.add(
            Slide(
                R.drawable.spidercover,
                "Spider Man"
            )
        )

    }

    fun createSlideBanner() {
        slidePager = findViewById(R.id.slider_pager)
        indicator = findViewById(R.id.indicator)

        var sliderPageAdapter =
            SliderPageAdapter(this, movieSliderData)
        slidePager.adapter = sliderPageAdapter

        var timer = Timer()
        timer.scheduleAtFixedRate(SliderTimer(), 4000, 6000)

        indicator.setupWithViewPager(slidePager, true)
    }

    override fun onMovieClick(movie: Movies, movieImage: ImageView) {
        // Here we will send movie information to the detail activity
        // also creating the transition animation between 2 activity

        var detailActivity = Intent(this, MovieDetailActivity::class.java)
        detailActivity.putExtra("title", movie.title)
        detailActivity.putExtra("description", movie.description)
        detailActivity.putExtra("imgURL", movie.thumbnail)
        detailActivity.putExtra("rating", movie.rating)
        detailActivity.putExtra("streaminglink", movie.streamingLink)
        detailActivity.putExtra("studio", movie.studio)
        detailActivity.putExtra("coverPic", movie.coverPhoto)


        var activityOptions =
            ActivityOptions.makeSceneTransitionAnimation(this, movieImage, "sharedName")


        startActivity(detailActivity, activityOptions.toBundle())

        Toast.makeText(this, "Item Clicked", Toast.LENGTH_SHORT).show()

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
