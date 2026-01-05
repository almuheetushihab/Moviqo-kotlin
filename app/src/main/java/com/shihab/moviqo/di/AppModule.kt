package com.shihab.moviqo.di

import android.app.Application
import androidx.room.Room
import com.shihab.moviqo.data.local.MovieDatabase
import com.shihab.moviqo.data.remote.TmdbApi
import com.shihab.moviqo.data.repository.MovieRepositoryImpl
import com.shihab.moviqo.domain.repository.MovieRepository
import com.shihab.moviqo.ui.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    // 1. Retrofit Instance Provider
    @Provides
    @Singleton
    fun provideTmdbApi(): TmdbApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)
    }

    // 2. Room Database Provider
    @Provides
    @Singleton
    fun provideMovieDatabase(app: Application): MovieDatabase {
        return Room.databaseBuilder(
            app,
            MovieDatabase::class.java,
            "moviqo_db"
        ).build()
    }

    // 3. Repository Provider
    @Provides
    @Singleton
    fun provideMovieRepository(
        api: TmdbApi,
        db: MovieDatabase
    ): MovieRepository {
        return MovieRepositoryImpl(api, db)
    }
}