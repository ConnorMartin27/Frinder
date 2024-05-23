package com.example.frinder.model

data class Card(
    val id: Int,
    val title: String,
    val description: String,
    val interests: List<String>,
    val imageUrl: String

)
