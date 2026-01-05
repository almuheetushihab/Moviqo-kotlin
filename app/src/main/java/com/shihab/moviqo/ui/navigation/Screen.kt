package com.shihab.moviqo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.PlayCircleOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector


sealed class Screen(val route: String, val title: String? = null, val icon: ImageVector? = null) {

    // Bottom Bar Screens
    object Home : Screen("home_screen", "Home", Icons.Default.Home)
    object Explore : Screen("explore_screen", "Explore", Icons.Default.Search)
    object Watchlist : Screen("watchlist_screen", "Watchlist", Icons.Default.List)
    object Settings : Screen("settings_screen", "Settings", Icons.Default.Settings)
    object Shorts : Screen("shorts_screen", "Shorts", Icons.Default.VideoLibrary)
    // Other Screens
    object Splash : Screen("splash_screen")
    object Onboarding : Screen("onboarding_screen")
    object MovieDetails : Screen("movie_details_screen/{movieId}") {
        fun createRoute(movieId: Int) = "movie_details_screen/$movieId"
    }
    object CastDetails : Screen("cast_details_screen/{castId}")
//    object Shorts : Screen("shorts_screen", "Shorts", Icons.Default.PlayCircleOutline)
}