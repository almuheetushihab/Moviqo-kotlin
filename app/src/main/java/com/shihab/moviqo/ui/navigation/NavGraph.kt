package com.shihab.moviqo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shihab.moviqo.ui.screen.details.MovieDetailsScreen
import com.shihab.moviqo.ui.screen.explore.ExploreScreen
import com.shihab.moviqo.ui.screen.home.HomeScreen
import com.shihab.moviqo.ui.screen.settings.SettingsScreen
import com.shihab.moviqo.ui.screen.splash.SplashScreen
import com.shihab.moviqo.ui.screen.watchlist.WatchlistScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route // অ্যাপ শুরু হবে স্প্ল্যাশ স্ক্রিন দিয়ে
    ) {
        // 1. Splash Screen
        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        // 2. Home Screen
        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        // 3. Explore Screen
        composable(Screen.Explore.route) {
            ExploreScreen(navController = navController)
        }

        // 4. Watchlist Screen (Fixed: ডুপ্লিকেট সরানো হয়েছে)
        composable(Screen.Watchlist.route) {
            WatchlistScreen(navController = navController)
        }

        // 5. Settings Screen (Fixed: ডুপ্লিকেট সরানো হয়েছে)
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }

        // 6. Movie Details
        composable(Screen.MovieDetails.route) { backStackEntry ->
            // আর্গুমেন্ট থেকে মুভি আইডি নেওয়া হচ্ছে
            val movieId = backStackEntry.arguments?.getString("movieId")
            MovieDetailsScreen(navController = navController, movieId = movieId)
        }
    }
}