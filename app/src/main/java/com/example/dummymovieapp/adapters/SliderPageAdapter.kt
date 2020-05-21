package com.example.dummymovieapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.example.dummymovieapp.R
import com.example.dummymovieapp.models.Slide
import kotlin.collections.ArrayList

class SliderPageAdapter(var ctx:Context,var slist:ArrayList<Slide>) : PagerAdapter() {

     var context:Context
     var slides:ArrayList<Slide>

    init {
        this.context=ctx
        slides=ArrayList()
        slides=slist

    }
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return slides.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        var inflater:LayoutInflater= context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        var slideLayout:View= inflater.inflate(R.layout.slider_item,null)

        var slideImage: ImageView =slideLayout.findViewById(R.id.slider_img)
        var slideText:TextView=slideLayout.findViewById(R.id.slider_title)

        slideImage.setImageResource(slides[position].Image)
        slideText.text=slides[position].Title.toString()

        container.addView(slideLayout)

        return slideLayout

    }
}