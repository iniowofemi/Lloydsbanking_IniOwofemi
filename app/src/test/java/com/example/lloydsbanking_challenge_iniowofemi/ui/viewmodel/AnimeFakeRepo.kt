package com.example.lloydsbanking_challenge_iniowofemi.ui.viewmodel

import com.example.lloydsbanking_challenge_iniowofemi.model.AnimeResponse
import com.example.lloydsbanking_challenge_iniowofemi.repository.AnimeRepository
import retrofit2.Response

class AnimeFakeRepo: AnimeRepository {
    override suspend fun getAnime(): Response<AnimeResponse> {
        val newAnimeList = Response.success(AnimeResponse(listOf(),null,null))
        return newAnimeList
    }
}