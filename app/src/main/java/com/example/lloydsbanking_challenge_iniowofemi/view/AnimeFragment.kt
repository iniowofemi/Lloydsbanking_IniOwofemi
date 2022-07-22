package com.example.lloydsbanking_challenge_iniowofemi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lloydsbanking_challenge_iniowofemi.adapter.AnimeAdapter
import com.example.lloydsbanking_challenge_iniowofemi.databinding.FragmentAnimeBinding
import com.example.lloydsbanking_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class AnimeFragment : BaseFragment() {

    private val binding by lazy{
        FragmentAnimeBinding.inflate(layoutInflater)
    }

    private val animeAdapter by lazy{
        AnimeAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        initRecyclerView()
        observeData()
        return binding.root
    }

    private fun initRecyclerView(){
        //Recycler View
        binding.animeRec.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = animeAdapter
        }
    }

    private fun observeData(){
        animeViewModel.anime.observe(viewLifecycleOwner) { state ->

            when (state) {
                is UIState.LOADING -> {
                }

                is UIState.SUCCESS2 -> {
                    animeAdapter.setAnime(state.response.data?.toMutableList() ?: mutableListOf())
                }

                is UIState.ERROR -> {
                    showError(state.error.localizedMessage){
                        animeViewModel.getAnime()
                    }
                }

                else -> {}
            }


        }

        animeViewModel.getAnime()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding.let{
            null
        }
    }
}