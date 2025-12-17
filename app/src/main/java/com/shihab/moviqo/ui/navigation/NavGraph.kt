package com.shihab.moviqo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shihab.moviqo.ui.screen.home.HomeScreen
// অন্য স্ক্রিনগুলোর ইমপোর্ট এখানে থাকবে...

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route // শুরু হবে স্প্ল্যাশ দিয়ে
    ) {
        // 1. Splash Screen
        composable(Screen.Splash.route) {
            // SplashScreen(navController) -> এটা আমরা পরে বানাবো
        }

        // 2. Home Screen
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // 3. Explore Screen
        composable(Screen.Explore.route) {
            // ExploreScreen(navController)
        }

        // 4. Watchlist Screen
        composable(Screen.Watchlist.route) {
            // WatchlistScreen(navController)
        }

        // 5. Settings Screen
        composable(Screen.Settings.route) {
            // SettingsScreen(navController)
        }

        composable(Screen.Watchlist.route) {
            WatchlistScreen(navController = navController)
        }

// 5. Settings Screen
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }

        // 6. Movie Details (With Argument)
        composable(Screen.MovieDetails.route) { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")
            // MovieDetailsScreen(navController, movieId)
        }
    }
}