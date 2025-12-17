package com.shihab.moviqo.ui.screen.shorts

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShortsScreen(navController: NavController) {
    val videoIds = listOf(
        "qEVUtrk8_B4",
        "JfVOs4VSpmA",
        "YoHD9XEInc0",
        "d9MyW72ELq0",
        "NmzuHjWmXOc"
    )

    val pagerState = rememberPagerState(pageCount = { videoIds.size })

    VerticalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) { page ->
        ShortsPlayerItem(
            videoId = videoIds[page],
            isPlaying = pagerState.currentPage == page
        )
    }
}

@Composable
fun ShortsPlayerItem(videoId: String, isPlaying: Boolean) {
    val context = LocalContext.current
    val lifecycleOwner = LocalLifecycleOwner.current
    var player by remember { mutableStateOf<YouTubePlayer?>(null) }

    LaunchedEffect(isPlaying) {
        if (isPlaying) {
            player?.play()
        } else {
            player?.pause()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            factory = { ctx ->
                YouTubePlayerView(ctx).apply {
                    lifecycleOwner.lifecycle.addObserver(this)
                    addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                        override fun onReady(youTubePlayer: YouTubePlayer) {
                            player = youTubePlayer
                            youTubePlayer.loadVideo(videoId, 0f)
                        }

                        override fun onStateChange(
                            youTubePlayer: YouTubePlayer,
                            state: PlayerConstants.PlayerState
                        ) {
                            if (state == PlayerConstants.PlayerState.ENDED) {
                                youTubePlayer.seekTo(0f)
                                youTubePlayer.play()
                            }
                        }
                    })
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}