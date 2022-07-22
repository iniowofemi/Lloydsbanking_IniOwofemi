package com.example.lloydsbanking_challenge_iniowofemi.utils

import com.example.lloydsbanking_challenge_iniowofemi.model.AnimeResponse
import com.example.lloydsbanking_challenge_iniowofemi.model.Data

sealed class UIState{

    object LOADING: UIState()
    data class SUCCESS(val response: MutableList<Data>): UIState()
    data class SUCCESS2(val response: AnimeResponse): UIState()
    data class ERROR (val error: Exception): UIState()

}