package com.example.elibreader.network

import com.example.elibreader.models.Book
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface OpenLibraryApi {

    // Получение книги по её идентификатору
    @GET("books/{id}.json")
    suspend fun getBookDetails(@Path("id") id: String): Book

    // Поиск книг по множеству параметров
    @GET("search.json")
    suspend fun searchBooks(
        @Query("q") query: String,              // Общий запрос для поиска
        @Query("title") title: String? = null,   // Поиск по заголовку
        @Query("author") author: String? = null, // Поиск по автору
        @Query("subject") subject: String? = null,// Поиск по жанру
        @Query("publish_year") publishYear: String? = null // Поиск по году публикации
    ): BookSearchResponse


}