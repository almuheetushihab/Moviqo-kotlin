package com.shihab.moviqo.ui.screen.settings

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController) {
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        TopAppBar(title = { Text("Settings") })

        // Privacy Policy Item
        ListItem(
            headlineContent = { Text("Privacy Policy") },
            leadingContent = { Icon(Icons.Default.Lock, contentDescription = null) },
            modifier = Modifier.clickable {
<<<<<<< HEAD
=======
                // আপনার প্রাইভেসি পলিসি লিংক এখানে দিন
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
                context.startActivity(intent)
            }
        )
        Divider()

        // About Item
        ListItem(
            headlineContent = { Text("About Moviqo") },
            supportingContent = { Text("Version 1.0.0") },
            leadingContent = { Icon(Icons.Default.Info, contentDescription = null) }
        )
    }
}