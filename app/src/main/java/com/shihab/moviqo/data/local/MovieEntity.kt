package com.shihab.moviqo.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.shihab.moviqo.domain.model.Movie

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String,
    val page: Int
) {
    fun toDomain(): Movie {
        return Movie(id, title, overview, posterPath, voteAverage, releaseDate)
    }
}

@Entity(tableName = "remote_keys")
data class RemoteKeys(
    @PrimaryKey val movieId: Int,
    val prevKey: Int?,
    val nextKey: Int?
)

@Entity(tableName = "favorite_movies")
data class FavoriteMovieEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val posterPath: String,
    val voteAverage: Double,
    val releaseDate: String
)