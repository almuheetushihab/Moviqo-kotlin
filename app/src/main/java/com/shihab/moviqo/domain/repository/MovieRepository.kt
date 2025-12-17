package com.shihab.moviqo.domain.repository

import androidx.paging.PagingData
import com.shihab.moviqo.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun getMovies(): Flow<PagingData<Movie>>
    suspend fun searchMovies(query: String): List<Movie>
    suspend fun getMovieDetails(id: Int): Movie

    // Favorites
    fun getAllFavorites(): Flow<List<Movie>>
    fun checkIsFavorite(id: Int): Flow<Boolean>
    suspend fun toggleFavorite(movie: Movie, isFavorite: Boolean)
}