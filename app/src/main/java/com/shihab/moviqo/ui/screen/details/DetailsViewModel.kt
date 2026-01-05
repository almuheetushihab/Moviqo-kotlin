package com.shihab.moviqo.ui.screen.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihab.moviqo.domain.model.Movie
import com.shihab.moviqo.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {

    private val _movieDetails = mutableStateOf<Movie?>(null)
    val movieDetails: State<Movie?> = _movieDetails

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _trailerUrl = mutableStateOf<String?>(null)
    val trailerUrl: State<String?> = _trailerUrl
    fun loadMovie(movieId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val id = movieId.toIntOrNull()
                if (id != null) {
                    val movie = repository.getMovieDetails(id)
                    _movieDetails.value = movie

                    val trailer = repository.getMovieTrailer(id)
                    _trailerUrl.value = trailer
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun isFavorite(movieId: Int): Flow<Boolean> {
        return repository.checkIsFavorite(movieId)
    }

    fun toggleFavorite(movie: Movie, isCurrentlyFavorite: Boolean) {
        viewModelScope.launch {
            repository.toggleFavorite(movie, isCurrentlyFavorite)
        }
    }

}