package com.shihab.moviqo.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.shihab.moviqo.data.local.FavoriteMovieEntity
import com.shihab.moviqo.data.local.MovieDatabase
import com.shihab.moviqo.data.paging.MovieRemoteMediator
import com.shihab.moviqo.data.remote.TmdbApi
import com.shihab.moviqo.domain.model.Movie
import com.shihab.moviqo.domain.repository.MovieRepository
import com.shihab.moviqo.ui.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi,
    private val db: MovieDatabase
) : MovieRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = MovieRemoteMediator(api, db),
            pagingSourceFactory = { db.movieDao().getMovies() }
        ).flow.map { pagingData ->
            pagingData.map { it.toDomain() }
        }
    }

    override suspend fun searchMovies(query: String): List<Movie> {
        return try {
            api.searchMovies(query = query).results.map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }

    override suspend fun getMovieDetails(id: Int): Movie {
        return api.getMovieDetails(movieId = id).toDomain()
    }

    override fun getAllFavorites(): Flow<List<Movie>> {
        return db.movieDao().getAllFavorites().map { entities ->
            entities.map {
                Movie(
                    id = it.id,
                    title = it.title,
                    overview = "",
                    voteAverage = it.voteAverage,
                    releaseDate = it.releaseDate,
                    posterPath = it.posterPath,
                    backdropPath = null
                )
            }
        }
    }

    override suspend fun getMovieTrailer(movieId: Int): String? {
        return try {
            val response = api.getMovieVideos(movieId = movieId, apiKey = Constants.API_KEY)
            val trailer = response.results.find { it.site == "YouTube" && it.type == "Trailer" }
            val videoKey = trailer?.key ?: response.results.firstOrNull()?.key

            if (videoKey != null) "https://www.youtube.com/watch?v=$videoKey" else null
        } catch (e: Exception) {
            null
        }
    }

    override suspend fun toggleFavorite(movie: Movie, isFavorite: Boolean) {
        val entity = FavoriteMovieEntity(
            id = movie.id,
            title = movie.title,
            posterPath = movie.posterPath ?: "",
            voteAverage = movie.voteAverage,
            releaseDate = movie.releaseDate
        )
        if (isFavorite) {
            db.movieDao().deleteFavorite(entity)
        } else {
            db.movieDao().insertFavorite(entity)
        }
    }

    override fun checkIsFavorite(id: Int): Flow<Boolean> {
        return db.movieDao().isFavorite(id)
    }
}