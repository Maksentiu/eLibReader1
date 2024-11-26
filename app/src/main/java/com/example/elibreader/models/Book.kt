package com.example.elibreader.models

data class Book(
    val id: String,
    val title: String,
    val authors: List<Author>,  // Список объектов Author
    val publishedYear: List<String>?,  // Может быть список
    val isbn: List<String>?,
    val publishers: List<String>?,
    val language: String?,
    val genres: List<String>?,
    val coverUrl: String?,  // URL обложки
    val numberOfPages: Int?
) {
    // Преобразование данных из API в формат, который нужен
    fun getAuthorNames(): List<String> {
        return authors.map { it.name }
    }
}