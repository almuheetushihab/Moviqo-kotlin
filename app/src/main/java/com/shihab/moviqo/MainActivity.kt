package com.shihab.moviqo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold

import androidx.navigation.compose.rememberNavController
import com.shihab.moviqo.ui.components.BottomNavigationBar
import com.shihab.moviqo.ui.navigation.SetupNavGraph
import com.shihab.moviqo.ui.theme.MoviqoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviqoTheme {
                val navController = rememberNavController()

                // Scaffold হলো একটি লেআউট যা টপ বার, বটম বার ম্যানেজ করে
                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) { innerPadding ->
                    // কন্টেন্ট এরিয়া (যেখানে স্ক্রিন চেঞ্জ হবে)
                    // innerPadding ব্যবহার করতে হবে যাতে কন্টেন্ট বটম বারের নিচে ঢাকা না পড়ে
                    androidx.compose.foundation.layout.Box(
                        modifier = androidx.compose.ui.Modifier.padding(innerPadding)
                    ) {
                        SetupNavGraph(navController = navController)
                    }
                }
            }
        }
    }
}