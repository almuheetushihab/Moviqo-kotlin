package com.shihab.moviqo.ui.screen.explore

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shihab.moviqo.domain.model.Movie
import com.shihab.moviqo.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExploreViewModel @Inject constructor(
    private val repository: MovieRepository
) : ViewModel() {
    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery
    private val _searchResults = mutableStateOf<List<Movie>>(emptyList())
    val searchResults: State<List<Movie>> = _searchResults
    private var searchJob: Job? = null

    fun onSearchChange(query: String) {
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            if (query.isNotEmpty()) {
                val results = repository.searchMovies(query)
                _searchResults.value = results
            }
        }
    }
}