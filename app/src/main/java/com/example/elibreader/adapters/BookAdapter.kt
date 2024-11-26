package com.example.elibreader.adapters

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.elibreader.models.Book

@Composable
fun BookItem(book: Book, onClick: () -> Unit) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = book.title, fontWeight = FontWeight.Bold)
        book.coverUrl?.let { url ->
            AsyncImage(
                model = url,
                contentDescription = "Book cover",
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(8.dp))
            )
        }
    }
}

@Composable
fun BookList(
    books: List<Book>,
    onBookClick: (Book) -> Unit,
    modifier: Modifier = Modifier,
    param: (Any) -> Unit
) {
    Column(modifier = modifier) {
        books.forEach { book ->
            BookItem(book = book, onClick = { onBookClick(book) })
        }
    }
}
