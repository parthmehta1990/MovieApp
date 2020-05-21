package com.example.dummymovieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var movieSliderData: ArrayList<Slide>
    lateinit var slidePager:ViewPager
    lateinit var indicator:TabLayout

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
        indicator=findViewById(R.id.indicator)

        var sliderPageAdapter=SliderPageAdapter(this,movieSliderData)
        slidePager.adapter=sliderPageAdapter

        var timer= Timer()
        timer.scheduleAtFixedRate(SliderTimer(),4000,6000)

        indicator.setupWithViewPager(slidePager,true)
    }

    internal inner class SliderTimer : TimerTask() {


       override fun run() {

            this@MainActivity.runOnUiThread(Runnable {
                if (slidePager.getCurrentItem() < movieSliderData.size - 1) {
                    slidePager.setCurrentItem(slidePager.getCurrentItem() + 1)
                } else
                    slidePager.setCurrentItem(0)
            })


        }
    }
}
