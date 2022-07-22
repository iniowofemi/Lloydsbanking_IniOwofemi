package com.example.lloydsbanking_challenge_iniowofemi.di

import com.example.lloydsbanking_challenge_iniowofemi.repository.AnimeRepository
import com.example.lloydsbanking_challenge_iniowofemi.repository.AnimeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideAnimeRepository(virginRepositoryImpl: AnimeRepositoryImpl): AnimeRepository

}