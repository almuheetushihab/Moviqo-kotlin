package com.shihab.moviqo.data.remote

data class VideoResponseDto(
    val results: List<VideoDto>
)

data class VideoDto(
    val key: String, // ইউটিউব ভিডিও আইডি
    val site: String, // যেমন: "YouTube"
    val type: String  // যেমন: "Trailer"
)