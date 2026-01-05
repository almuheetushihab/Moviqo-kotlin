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

                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(navController = navController)
                    }
                ) { innerPadding ->
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