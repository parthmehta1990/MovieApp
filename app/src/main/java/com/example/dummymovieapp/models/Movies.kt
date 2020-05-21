package com.example.dummymovieapp.models

data class Movies(
    var title: String,
    var description: String = "",
    var thumbnail: Int,
    var studio: String = "",
    var rating: String = "",
    var streamingLink: String = "",
    var coverPhoto: Int=0
)