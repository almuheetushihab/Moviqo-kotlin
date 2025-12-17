package com.shihab.moviqo.data.remote

interface TmdbApi {
    // ... আগের কোড ...

    @GET("search/movie")
    suspend fun searchMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("query") query: String
    ): MovieResponseDto

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = Constants.API_KEY
    ): MovieDto // MovieDto রিটার্ন করবে

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = Constants.API_KEY,
        @Query("page") page: Int
    ): MovieResponseDto
}