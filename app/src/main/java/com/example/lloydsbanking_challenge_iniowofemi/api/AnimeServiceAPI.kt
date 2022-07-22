package com.example.lloydsbanking_challenge_iniowofemi.api

import com.example.lloydsbanking_challenge_iniowofemi.api.AnimeServiceAPI.Companion.IMG_PATH
import com.example.lloydsbanking_challenge_iniowofemi.model.AnimeResponse
import retrofit2.Response
import retrofit2.http.GET

interface AnimeServiceAPI {
    @GET(ANIME_PATH)
    suspend fun getAnime(): Response<AnimeResponse>

    @GET(IMG_PATH)
    suspend fun getInfo(): Response<AnimeResponse>

    companion object {
        const val BASE_URL = "https://kitsu.io/api/"
        private const val ANIME_PATH = "edge/anime/"
        private const val IMG_PATH = "edge/anime/poster_images/{id}/medium.jpg"
    }
}