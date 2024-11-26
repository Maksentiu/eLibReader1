package com.example.elibreader.network

import com.example.elibreader.models.Book

data class BookSearchResponse(
    val numFound: Int,          // Общее количество найденных книг
    val docs: List<Book>        // Список книг, найденных по запросу
)