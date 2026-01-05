package com.shihab.moviqo.data.remote

data class VideoResponseDto(
    val results: List<VideoDto>
)

data class VideoDto(
    val key: String,
    val site: String,
    val type: String
)