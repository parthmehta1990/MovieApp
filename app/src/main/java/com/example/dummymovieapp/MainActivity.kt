package com.example.dummymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    lateinit var movieSliderData: ArrayList<Slide>
    lateinit var slidePager:ViewPager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createSliderData()
        createSlideBanner()


    }

    fun createSliderData(){
        //Initialize the slider data variable
        movieSliderData = ArrayList()

        movieSliderData.add(Slide(R.drawable.slide1,"X-Man"))
        movieSliderData.add(Slide(R.drawable.slide2,"Harry Potter"))
        movieSliderData.add(Slide(R.drawable.spidercover,"Spider Man"))
        movieSliderData.add(Slide(R.drawable.slide1,"X-Man"))
        movieSliderData.add(Slide(R.drawable.slide2,"Harry Potter"))
        movieSliderData.add(Slide(R.drawable.spidercover,"Spider Man"))

    }

    fun createSlideBanner(){
        slidePager=findViewById(R.id.slider_pager)

        var sliderPageAdapter=SliderPageAdapter(this,movieSliderData)
        slidePager.adapter=sliderPageAdapter
    }
}
