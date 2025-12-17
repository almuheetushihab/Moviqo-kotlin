package com.shihab.moviqo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shihab.moviqo.domain.model.Movie

// 1. Caching এর জন্য মেইন টেবিল
@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String,
    val page: Int // পেজিং এর জন্য
) {
    fun toDomain(): Movie {
        return Movie(id, title, overview, posterPath, voteAverage, releaseDate)
    }
}

// 2. Paging Key রাখার জন্য টেবিল
@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey val movieId: Int,
    val prevKey: Int?,
    val nextKey: Int?
)

// 3. Favorites টেবিল (Redeclaration এরর ফিক্স করার জন্য এটি শুধু এখানেই থাকবে)
@Entity(tableName = "favorite_movies")
data class FavoriteMovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String
)