package com.example.elibreader.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.elibreader.network.BookSearchResponse
import com.example.elibreader.repositorys.BookRepository
import kotlinx.coroutines.launch

class BookViewModel : ViewModel() {
    private val repository = BookRepository()
    var searchResults: BookSearchResponse? = null
    var errorMessage: String? = null

    fun fetchSearchResults(query: String) {
        viewModelScope.launch {
            try {
                searchResults = repository.searchBooks(query)
                errorMessage = null
            } catch (e: Exception) {
                errorMessage = e.message
            }
        }
    }
}