package com.example.lloydsbanking_challenge_iniowofemi

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.lloydsbanking_challenge_iniowofemi.ui.viewmodel.AnimeFakeRepo
import com.example.lloydsbanking_challenge_iniowofemi.utils.UIState
import com.example.lloydsbanking_challenge_iniowofemi.viewmodel.AnimeViewModel
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Test
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class ViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var tempRepository: AnimeFakeRepo
    private lateinit var tempViewModel: AnimeViewModel

    @Before
    fun setUp() {
        tempRepository = AnimeFakeRepo()
        tempViewModel = AnimeViewModel(tempRepository)
    }

    @Test
    fun hasAnimeList() {
        var expectedState = UIState.LOADING
        tempViewModel.anime.observeForever{
            assertThat(it).isNotNull()
            assertThat(it).isEqualTo(expectedState)
        }
        tempViewModel.getAnime()
    }
}