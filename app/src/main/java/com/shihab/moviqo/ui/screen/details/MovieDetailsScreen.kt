package com.shihab.moviqo.ui.screen.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shihab.moviqo.ui.Constants

@Composable
fun MovieDetailsScreen(
    navController: NavController,
    movieId: String?, // Navigation থেকে আসবে
    viewModel: DetailsViewModel = hiltViewModel()
) {
    // ১. স্ক্রিন ওপেন হলে ডেটা লোড করা
    LaunchedEffect(key1 = movieId) {
        movieId?.let { viewModel.loadMovie(it) }
    }

    val movie = viewModel.movieDetails.value
    val isLoading = viewModel.isLoading.value

    // ২. ফেভারিট স্ট্যাটাস চেক করা (যদি মুভি লোড হয়ে থাকে)
    val isFavoriteState = if (movie != null) {
        viewModel.isFavorite(movie.id).collectAsState(initial = false)
    } else {
        remember { mutableStateOf(false) } // ডামি স্টেট
    }
    val isFavorite = isFavoriteState.value

    // ৩. লোডিং বা এরর হ্যান্ডলিং
    if (isLoading || movie == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator(color = Color(0xFFE50914))
        }
        return
    }

    // ৪. মেইন UI (Scaffold ব্যবহার করছি যাতে FAB বসানো যায়)
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { viewModel.toggleFavorite(movie, isFavorite) },
                containerColor = Color.White,
                shape = CircleShape,
                elevation = FloatingActionButtonDefaults.elevation(8.dp)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Toggle Favorite",
                    tint = if (isFavorite) Color.Red else Color.Black
                )
            }
        },
        containerColor = Color.Black // পুরো স্ক্রিনের ব্যাকগ্রাউন্ড কালো
    ) { padding -> // padding প্যারামিটারটি ইগনোর করছি কাস্টম ডিজাইনের জন্য

        Box(modifier = Modifier.fillMaxSize()) {
            // A. Backdrop Image (Background)
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("${Constants.IMAGE_BASE_URL}${movie.posterPath}")
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp) // ছবির হাইট একটু বাড়ালাম
            )

            // B. Back Button
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier
                    .padding(top = 48.dp, start = 16.dp)
                    .background(Color.Black.copy(alpha = 0.4f), CircleShape)
            ) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color.White)
            }

            // C. Bottom Gradient & Content
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 380.dp) // ছবির নিচ থেকে শুরু হবে
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color(0xFF141414), // Netflix Dark Grey
                                Color(0xFF141414)
                            ),
                            startY = 0f,
                            endY = 300f
                        )
                    )
                    .verticalScroll(rememberScrollState())
            ) {
                Column(modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)) {
                    // Title
                    Text(
                        text = movie.title,
                        color = Color.White,
                        fontSize = 32.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 38.sp
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    // Meta Data (Rating, Date)
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Match ${String.format("%.0f", movie.voteAverage * 10)}%",
                            color = Color(0xFF46D369), // Netflix Match Green
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Text(
                            text = movie.releaseDate.take(4), // শুধু সাল (Year) দেখাবে
                            color = Color.LightGray,
                            fontSize = 14.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Watch Trailer Button
                    Button(
                        onClick = { /* Trailer Logic Placeholder */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color.Black)
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("Watch Trailer", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    }

                    Spacer(modifier = Modifier.height(24.dp))

                    // Overview
                    Text(
                        text = movie.overview,
                        color = Color.White,
                        fontSize = 15.sp,
                        lineHeight = 22.sp,
                        fontWeight = FontWeight.Light
                    )

                    // Extra Space for FAB visibility at bottom
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}