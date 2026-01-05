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
<<<<<<< HEAD
    val items = listOf(
        Screen.Home,
        Screen.Explore,
        Screen.Shorts,
=======
    // 🔥 লিস্টে Shorts যোগ করা হয়েছে
    val items = listOf(
        Screen.Home,
        Screen.Explore,
        Screen.Shorts,   // 👈 মাঝখানে থাকল
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
        Screen.Watchlist,
        Screen.Settings
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val showBottomBar = items.any { it.route == currentRoute }

    if (showBottomBar) {
        NavigationBar(
<<<<<<< HEAD
            containerColor = Color.Black,
=======
            containerColor = Color.Black, // ব্যাকগ্রাউন্ড কালো দিলে মুভি অ্যাপে ভালো লাগে
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
            contentColor = Color.White
        ) {
            items.forEach { screen ->
                NavigationBarItem(
                    icon = {
                        Icon(
                            imageVector = screen.icon!!,
                            contentDescription = screen.title
                        )
                    },
                    label = { Text(text = screen.title!!) },
                    selected = currentRoute == screen.route,
                    onClick = {
                        navController.navigate(screen.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
<<<<<<< HEAD
                        selectedIconColor = Color(0xFFE50914),
                        selectedTextColor = Color(0xFFE50914),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color.Transparent
=======
                        selectedIconColor = Color(0xFFE50914), // Netflix Red
                        selectedTextColor = Color(0xFFE50914),
                        unselectedIconColor = Color.Gray,
                        unselectedTextColor = Color.Gray,
                        indicatorColor = Color.Transparent // সিলেকশন ব্যাকগ্রাউন্ড সরালাম
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                    )
                )
            }
        }
    }
}