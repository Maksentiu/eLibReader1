package com.example.elibreader.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.elibreader.models.Book

@Composable
fun BookDetailScreen(navController: NavController, book: Book) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {

        // Заголовок книги
        Text(text = book.title, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.headlineMedium)

        // Обложка книги
        book.coverUrl?.let { url ->
            AsyncImage(
                model = url,
                contentDescription = "Book cover",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(vertical = 16.dp)
            )
        }

        // Авторы
        book.authors?.let { authors ->
            Text(text = "Authors: ${authors.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        }

        // Год публикации
        book.publishedYear?.let { year ->
            Text(text = "Published Year: $year", style = MaterialTheme.typography.bodyMedium)
        }

        // Жанры
        book.genres?.let { genres ->
            Text(text = "Genres: ${genres.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        }

        // ISBN
        book.isbn?.let { isbnList ->
            Text(text = "ISBN: ${isbnList.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        }

        // Издатели
        book.publishers?.let { publishers ->
            Text(text = "Publishers: ${publishers.joinToString(", ")}", style = MaterialTheme.typography.bodyMedium)
        }

        // Количество страниц
        book.numberOfPages?.let { pages ->
            Text(text = "Number of Pages: $pages", style = MaterialTheme.typography.bodyMedium)
        }
    }
}