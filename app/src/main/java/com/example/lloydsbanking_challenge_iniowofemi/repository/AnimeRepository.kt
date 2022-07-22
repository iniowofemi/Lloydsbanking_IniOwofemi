package com.example.lloydsbanking_challenge_iniowofemi.repository

import com.example.lloydsbanking_challenge_iniowofemi.api.AnimeServiceAPI
import com.example.lloydsbanking_challenge_iniowofemi.model.AnimeResponse
import retrofit2.Response
import javax.inject.Inject

interface AnimeRepository {
    suspend fun getAnime(): Response<AnimeResponse>
    suspend fun getInfo(): Response<AnimeResponse>
}

class AnimeRepositoryImpl @Inject constructor (
    private val animeServiceApi: AnimeServiceAPI
) : AnimeRepository{

    override suspend fun getAnime(): Response<AnimeResponse> {
        return animeServiceApi.getAnime()
    }

    override suspend fun getInfo(): Response<AnimeResponse> {
        return animeServiceApi.getInfo()
    }
}