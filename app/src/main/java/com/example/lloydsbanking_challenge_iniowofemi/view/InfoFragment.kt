package com.example.lloydsbanking_challenge_iniowofemi.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lloydsbanking_challenge_iniowofemi.R
import com.example.lloydsbanking_challenge_iniowofemi.adapter.AnimeAdapter
import com.example.lloydsbanking_challenge_iniowofemi.adapter.InfoAdapter
import com.example.lloydsbanking_challenge_iniowofemi.databinding.FragmentAnimeBinding
import com.example.lloydsbanking_challenge_iniowofemi.databinding.FragmentInfoBinding
import com.example.lloydsbanking_challenge_iniowofemi.utils.UIState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfoFragment : BaseFragment() {

    private val binding by lazy{
        FragmentInfoBinding.inflate(layoutInflater)
    }

    private val infoAdapter by lazy{
        InfoAdapter()
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
        binding.infoRec.apply {
            this.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = infoAdapter
        }
    }

    private fun observeData(){
        animeViewModel.anime.observe(viewLifecycleOwner) { state ->

            when (state) {
                is UIState.LOADING -> {
                }

                is UIState.SUCCESS2 -> {
                    infoAdapter.setInfo(state.response.data?.toMutableList() ?: mutableListOf())
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