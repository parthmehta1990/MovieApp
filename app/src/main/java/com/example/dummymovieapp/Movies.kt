package com.example.dummymovieapp

data class Movies(
    var title:String,
    var description:String="",
    var thumbnail:Int,
    var studio:String="",
    var rating:String="",
    var streamingLink:String=""
)