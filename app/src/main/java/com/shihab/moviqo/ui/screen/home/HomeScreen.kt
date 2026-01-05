package com.shihab.moviqo.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import com.shihab.moviqo.ui.components.HomeTopBar
import com.shihab.moviqo.ui.components.MovieCard
import com.shihab.moviqo.ui.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val movies = viewModel.moviePagingFlow.collectAsLazyPagingItems()

    Scaffold(
<<<<<<< HEAD
=======
        // ১. এখানে আমাদের কাস্টম টপ বার বসানো হলো
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
        topBar = {
            HomeTopBar(
                onSearchClick = { navController.navigate(Screen.Explore.route) }
            )
        },
        containerColor = Color(0xFFF5F5F5)
    ) { padding ->

        if (movies.loadState.refresh is LoadState.Loading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color(0xFFE50914))
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(
                    top = padding.calculateTopPadding(),
<<<<<<< HEAD
                    bottom = padding.calculateBottomPadding() + 80.dp,
=======
                    bottom = padding.calculateBottomPadding() + 80.dp, // BottomBar এর জন্য স্পেস
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                    start = 8.dp,
                    end = 8.dp
                ),
                modifier = Modifier.fillMaxSize()
            ) {
<<<<<<< HEAD
=======
                // ২. "Trending Now" লেখাটি এখন গ্রিডের ভেতরে হেডার হিসেবে থাকবে
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = "Trending Now 🔥",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
                    )
                }

<<<<<<< HEAD
=======
                // মুভি লিস্ট
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                items(movies.itemCount) { index ->
                    val movie = movies[index]
                    if (movie != null) {
                        MovieCard(movie = movie) {
                            navController.navigate(Screen.MovieDetails.createRoute(movie.id))
                        }
                    }
                }

<<<<<<< HEAD
=======
                // পেজ লোডিং লোডার (নিচে)
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
                item(span = { GridItemSpan(2) }) {
                    if (movies.loadState.append is LoadState.Loading) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(color = Color(0xFFE50914))
                        }
                    }
                }
            }

<<<<<<< HEAD
=======
            // ইন্টারনেট এরর হ্যান্ডলিং
>>>>>>> 8ae55afdb29bb7667223b57bacd543f23387ddf4
            if (movies.loadState.refresh is LoadState.Error) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.WifiOff,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(50.dp)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("No Internet Connection", color = Color.Gray)
                        Spacer(modifier = Modifier.height(16.dp))
                        Button(
                            onClick = { movies.retry() },
                            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE50914))
                        ) {
                            Text("Retry")
                        }
                    }
                }
            }
        }
    }
}