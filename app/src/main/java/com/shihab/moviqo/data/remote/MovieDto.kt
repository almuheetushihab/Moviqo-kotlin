package com.shihab.moviqo.data.remote

import com.google.gson.annotations.SerializedName
import com.shihab.moviqo.domain.model.Movie

data class MovieResponseDto(
    val results: List<MovieDto>
)

data class MovieDto(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("release_date") val releaseDate: String?
) {
    // DTO থেকে Domain মডেলে কনভার্ট করার ফাংশন
    fun toDomain(): Movie {
        return Movie(
            id = id,
            title = title,
            overview = overview,
            posterPath = posterPath ?: "",
            voteAverage = voteAverage,
            releaseDate = releaseDate ?: "Unknown"
        )
    }
}