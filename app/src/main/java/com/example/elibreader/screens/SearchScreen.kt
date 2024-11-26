package com.example.elibreader.screens


import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.elibreader.R
import com.example.elibreader.Routes
import com.example.elibreader.adapters.BookItem
import com.example.elibreader.adapters.BookList
import com.example.elibreader.models.BookViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun SearchScreen(navController: NavHostController) {
    val viewModel: BookViewModel = viewModel()
    var query by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = Routes.searchScreen,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF00E676),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomAppBar(modifier = Modifier.height(70.dp)) {
                Row(modifier = Modifier.fillMaxSize()) {
                    Spacer(modifier = Modifier.weight(0.5f))

                    IconButton(onClick = { navController.navigate(Routes.settingsScreen) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.settings), // Используйте ресурс иконки
                            contentDescription = "Settings",
                            tint = Color.Unspecified // Используйте цвет по умолчанию или задайте свой
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.75f))
                    IconButton(onClick = { navController.navigate(Routes.favoritesScreen) }) {
                        Icon(
                            painter = painterResource(id = R.drawable.favorites), // Используйте ресурс иконки
                            contentDescription = "Favorites",
                            tint = Color.Unspecified // Используйте цвет по умолчанию или задайте свой
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.5f))
                    IconButton(onClick = {  }) {
                        Icon(
                            painter = painterResource(id = R.drawable.exit), // Используйте ресурс иконки
                            contentDescription = "Exit",
                            tint = Color.Unspecified // Используйте цвет по умолчанию или задайте свой
                        )
                    }
                    Spacer(modifier = Modifier.weight(0.5f))
                }
            }
        },
        content = { paddingValues ->
            Row(
                Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(paddingValues)
            )
            {
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(0.7f)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    value = query,
                    onValueChange = { query = it },
                    label = {
                        Text(
                            text = "Search for books",
                            fontStyle = FontStyle.Italic,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF00E676)
                        )},
                    colors = TextFieldDefaults.colors(Color(0xFF00E676))
                )
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    onClick = { viewModel.fetchSearchResults(query) },
                    colors = ButtonDefaults.buttonColors(Color(0xFF00E676))) {
                    Text(text = "Search",
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black)

                }

                /*viewModel.searchResults?.docs?.let { books ->
                    LazyColumn {
                        items(books) { book ->
                            BookItem(book,
                                onClick = {navController.navigate(Routes.bookDetailScreen))
                        }
                    }
                }

                // Обработка ошибок
                viewModel.errorMessage?.let { error ->
                    Text(text = error, color = MaterialTheme.colorScheme.error)
                }*/

                BookList(books = viewModel.searchResults?.docs ?: emptyList())},
                    modifier = Modifier) { book ->
                    // Обработка нажатия на книгу
                    navController.navigate("bookDetails/${book.id}")
                }
            }
        }
    )
}

