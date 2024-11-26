package com.example.elibreader.repositorys

import com.example.elibreader.network.RetrofitInstanceOpenlibrary
import com.example.elibreader.models.Book
import com.example.elibreader.network.BookSearchResponse

class BookRepository {

    suspend fun getBookDetails(id: String): Book {
        return RetrofitInstanceOpenlibrary.api.getBookDetails(id)
    }

    suspend fun searchBooks(query: String): BookSearchResponse {
        return RetrofitInstanceOpenlibrary.api.searchBooks(query)
    }
}