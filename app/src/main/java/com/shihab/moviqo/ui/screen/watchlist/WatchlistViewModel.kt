package com.shihab.moviqo.ui.screen.watchlist

import androidx.lifecycle.ViewModel
import com.shihab.moviqo.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WatchlistViewModel @Inject constructor(
    repository: MovieRepository
) : ViewModel() {
    val favorites = repository.getAllFavorites()
}