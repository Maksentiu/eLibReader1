package com.example.elibreader.models

data class FavoriteItemModel(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String? = null // Может быть null, если изображение не предоставлено
)
