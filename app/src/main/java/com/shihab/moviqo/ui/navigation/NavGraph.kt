package com.shihab.moviqo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shihab.moviqo.ui.screen.details.MovieDetailsScreen
import com.shihab.moviqo.ui.screen.explore.ExploreScreen
import com.shihab.moviqo.ui.screen.home.HomeScreen
import com.shihab.moviqo.ui.screen.settings.SettingsScreen
import com.shihab.moviqo.ui.screen.shorts.ShortsScreen
import com.shihab.moviqo.ui.screen.splash.SplashScreen
import com.shihab.moviqo.ui.screen.watchlist.WatchlistScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
<<<<<<< HEAD
        startDestination = Screen.Splash.route
=======
        startDestination = Screen.Splash.route // অ্যাপ শুরু হবে স্প্ল্যাশ স্ক্রিন দিয়ে
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
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

<<<<<<< HEAD
        // 4. Watchlist Screen
=======
        // 4. Watchlist Screen (Fixed: ডুপ্লিকেট সরানো হয়েছে)
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
        composable(Screen.Watchlist.route) {
            WatchlistScreen(navController = navController)
        }

<<<<<<< HEAD
        // 5. Settings Screen
=======
        // 5. Settings Screen (Fixed: ডুপ্লিকেট সরানো হয়েছে)
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
        composable(Screen.Settings.route) {
            SettingsScreen(navController = navController)
        }

        // 6. Movie Details
        composable(Screen.MovieDetails.route) { backStackEntry ->
<<<<<<< HEAD
=======
            // আর্গুমেন্ট থেকে মুভি আইডি নেওয়া হচ্ছে
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
            val movieId = backStackEntry.arguments?.getString("movieId")
            MovieDetailsScreen(navController = navController, movieId = movieId)
        }
        composable(Screen.Shorts.route) {
            ShortsScreen(navController = navController)
        }
    }
}