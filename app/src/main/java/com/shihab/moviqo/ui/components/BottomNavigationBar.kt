package com.shihab.moviqo.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.shihab.moviqo.ui.navigation.Screen

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        Screen.Home,
        Screen.Explore,
        Screen.Watchlist,
        Screen.Settings
    )

    // বর্তমান রুট চেক করা (যাতে বাটন হাইলাইট হয়)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // স্প্ল্যাশ বা ডিটেইলস স্ক্রিনে বটম বার দেখাবো না
    val showBottomBar = items.any { it.route == currentRoute }

    if (showBottomBar) {
        NavigationBar(
            containerColor = Color.White, // অথবা আপনার থিম কালার
            contentColor = Color.Black
        ) {
            items.forEach { screen ->
                NavigationBarItem(
                    icon = { Icon(imageVector = screen.icon!!, contentDescription = screen.title) },
                    label = { Text(text = screen.title!!) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            // ব্যাক বাটন চাপলে যাতে অ্যাপ বন্ধ না হয়ে হোমে আসে
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0xFFE50914), // Netflix Red Style
                        selectedTextColor = Color(0xFFE50914),
                        indicatorColor = Color(0xFFE50914).copy(alpha = 0.1f)
                    )
                )
            }
        }
    }
}