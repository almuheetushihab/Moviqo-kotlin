package com.shihab.moviqo.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.WifiOff
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
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
                    top = padding.calculateTopPadding() + 8.dp,
                    bottom = padding.calculateBottomPadding() + 80.dp,
                    start = 12.dp,
                    end = 12.dp
                ),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {

                if (movies.itemCount > 0) {
                    item(span = { GridItemSpan(2) }) {
                        movies[0]?.let { firstMovie ->
                            HeroBanner(
                                imageUrl = "https://image.tmdb.org/t/p/w780${firstMovie.posterPath}",
                                title = firstMovie.title,
                                onClick = { navController.navigate(Screen.MovieDetails.createRoute(firstMovie.id)) }
                            )
                        }
                    }
                }

                item(span = { GridItemSpan(2) }) {
                    Text(
                        text = "Trending Now 🔥",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                    )
                }

                items(movies.itemCount) { index ->
                    val movie = movies[index]
                    if (movie != null && index > 0) {
                        MovieCard(movie = movie) {
                            navController.navigate(Screen.MovieDetails.createRoute(movie.id))
                        }
                    }
                }

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

            if (movies.loadState.refresh is LoadState.Error) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = Icons.Default.WifiOff,
                            contentDescription = null,
                            tint = Color.Gray,
                            modifier = Modifier.size(50.dp)
                        )
                        Text("No Internet Connection", color = Color.Gray)
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

@Composable
fun HeroBanner(imageUrl: String, title: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "Featured Movie",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                        startY = 100f
                    )
                )
        )

        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)
        ) {
            Badge(
                containerColor = Color(0xFFE50914),
                contentColor = Color.White,
                modifier = Modifier.padding(bottom = 8.dp)
            ) {
                Text("Featured", modifier = Modifier.padding(4.dp))
            }

            Text(
                text = title,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1
            )
        }

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = null,
            tint = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .size(48.dp)
                .background(Color.Black.copy(alpha = 0.4f), shape = RoundedCornerShape(50))
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HeroBannerPreview() {
    MaterialTheme {
        Box(modifier = Modifier.padding(16.dp)) {
            HeroBanner(
                imageUrl = "",
                title = "Avatar: The Way of Water",
                onClick = {}
            )
        }
    }
}