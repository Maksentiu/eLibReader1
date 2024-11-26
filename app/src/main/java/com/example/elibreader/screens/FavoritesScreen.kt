package com.example.elibreader.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.elibreader.Routes
import com.example.elibreader.models.FavoriteItemModel
import com.example.elibreader.models.FavoritesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritesScreen(navController: NavController) {
    val viewModel: FavoritesViewModel = viewModel()
    val favorites by viewModel.favorites.collectAsState()

    Scaffold (
        modifier = Modifier.fillMaxSize(),

        topBar = {
            CenterAlignedTopAppBar(
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(Routes.searchScreen) }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.White)
                    }
                },
                title = {
                    Text(text = Routes.favoritesScreen, color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color(0xFF00E676),
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Favorites",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(16.dp)
                )

                // Проверка на наличие избранных элементов
                if (favorites.isEmpty()) {
                    Text("No favorites yet.", style = MaterialTheme.typography.bodyMedium)
                } else {
                    LazyColumn {
                        items(favorites) { favorite ->
                            FavoriteItem(favorite) {
                                // Навигация к экрану деталей
                                navController.navigate("detail/${favorite.id}")
                            }
                        }
                    }
                }

                // Кнопка для очистки избранного
                Button(
                    onClick = { viewModel.clearFavorites() },
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text("Clear Favorites")
                }
            }
        }
    )
}

@Composable
fun FavoriteItem(favorite: FavoriteItemModel, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = favorite.title, style = MaterialTheme.typography.titleMedium)
            Text(text = favorite.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}