package com.shihab.moviqo.ui.screen.explore

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.shihab.moviqo.ui.components.MovieCard
import com.shihab.moviqo.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExploreScreen(
    navController: NavController,
    viewModel: ExploreViewModel = hiltViewModel()
) {
    val query = viewModel.searchQuery.value
    val results = viewModel.searchResults.value

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
<<<<<<< HEAD
=======
        // Search Bar
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
        OutlinedTextField(
            value = query,
            onValueChange = { viewModel.onSearchChange(it) },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text("Search movies...") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            shape = RoundedCornerShape(24.dp),
            colors = OutlinedTextFieldDefaults.colors(
<<<<<<< HEAD
                focusedBorderColor = Color(0xFFE50914),
                cursorColor = Color(0xFFE50914),
                unfocusedBorderColor = Color.Gray
=======
                focusedBorderColor = Color(0xFFE50914), // ফোকাস করলে লাল বর্ডার
                cursorColor = Color(0xFFE50914),        // লাল কার্সর
                unfocusedBorderColor = Color.Gray       // ফোকাস না থাকলে গ্রে
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Search Results Grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {
            items(results) { movie ->
                MovieCard(movie = movie) {
                    navController.navigate(Screen.MovieDetails.createRoute(movie.id))
                }
            }
        }
    }
}