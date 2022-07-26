package com.example.lloydsbanking_challenge_iniowofemi.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.lloydsbanking_challenge_iniowofemi.repository.AnimeRepository
import com.example.lloydsbanking_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val animeRepository: AnimeRepository
) : ViewModel() {

    private val _anime: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val anime: LiveData<UIState> get() = _anime

    fun getAnime() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = animeRepository.getAnime()
                if (response.isSuccessful) {
                    response.body()?.let {
                        _anime.postValue(UIState.SUCCESS2(it))
                    } ?: throw Exception("Data Null")
                } else {
                    throw Exception(response.errorBody()?.string())
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    _anime.postValue(UIState.ERROR(e))
                }
            }
        }
    }
}