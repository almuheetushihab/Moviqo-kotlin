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

<<<<<<< HEAD
=======
    // মুভি ডিটেইলস রাখার জন্য স্টেট
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
    private val _movieDetails = mutableStateOf<Movie?>(null)
    val movieDetails: State<Movie?> = _movieDetails

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading
    private val _trailerUrl = mutableStateOf<String?>(null)
    val trailerUrl: State<String?> = _trailerUrl
<<<<<<< HEAD
=======
    // ১. API থেকে মুভি লোড করা
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
    fun loadMovie(movieId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val id = movieId.toIntOrNull()
                if (id != null) {
<<<<<<< HEAD
                    val movie = repository.getMovieDetails(id)
                    _movieDetails.value = movie

=======
                    // ১. মুভি ডিটেইলস আনা
                    val movie = repository.getMovieDetails(id)
                    _movieDetails.value = movie

                    // ২. ট্রেলার লিংক আনা (নতুন কোড) 🔥
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
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

<<<<<<< HEAD
=======
    // ২. মুভিটি ফেভারিট কিনা চেক করা
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
    fun isFavorite(movieId: Int): Flow<Boolean> {
        return repository.checkIsFavorite(movieId)
    }

<<<<<<< HEAD
=======
    // ৩. ফেভারিট বাটনে ক্লিক করলে সেভ/ডিলিট করা
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
    fun toggleFavorite(movie: Movie, isCurrentlyFavorite: Boolean) {
        viewModelScope.launch {
            repository.toggleFavorite(movie, isCurrentlyFavorite)
        }
    }

}