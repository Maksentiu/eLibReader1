package com.example.elibreader.models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FavoritesViewModel : ViewModel() {
    // Состояние для хранения списка избранных элементов
    private val _favorites = MutableStateFlow<List<FavoriteItemModel>>(emptyList())
    val favorites: StateFlow<List<FavoriteItemModel>> = _favorites

    // Метод для добавления элемента в избранное
    fun addFavorite(item: FavoriteItemModel) {
        viewModelScope.launch {
            _favorites.value = _favorites.value + item
        }
    }

    // Метод для удаления элемента из избранного
    fun removeFavorite(item: FavoriteItemModel) {
        viewModelScope.launch {
            _favorites.value = _favorites.value.filter { it.id != item.id }
        }
    }

    // Метод для очистки всех избранных элементов
    fun clearFavorites() {
        viewModelScope.launch {
            _favorites.value = emptyList()
        }
    }
}