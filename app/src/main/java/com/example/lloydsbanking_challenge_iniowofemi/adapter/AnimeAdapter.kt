package com.example.lloydsbanking_challenge_iniowofemi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lloydsbanking_challenge_iniowofemi.databinding.AnimeEntryBinding
import com.example.lloydsbanking_challenge_iniowofemi.model.Data
import com.squareup.picasso.Picasso

class AnimeAdapter(
    private val mAnimeList: MutableList<Data> = mutableListOf()
) : RecyclerView.Adapter<MyViewHolder>(
) {

    fun setAnime(anime: MutableList<Data>) {
        mAnimeList.clear()
        mAnimeList.addAll(anime)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : MyViewHolder =
        MyViewHolder(
            AnimeEntryBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) =
        holder.bind(mAnimeList[position])

    override fun getItemCount(): Int  = mAnimeList.size

}

class MyViewHolder (
    private val binding: AnimeEntryBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Data) {
        binding.animeTitle.text = data.attributes?.canonicalTitle ?: "Title N/A"
        binding.synopsis.text = data.attributes?.synopsis ?: "No synopsis available."
        Picasso.get()
            .load(data.attributes?.posterImage?.medium)
//            .load("https://media.kitsu.io/anime/poster_images/1/small.jpg")
            .fit()
            .into(binding.animePfpMedium)
    }
}