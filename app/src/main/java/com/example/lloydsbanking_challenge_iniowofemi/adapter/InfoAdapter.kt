package com.example.lloydsbanking_challenge_iniowofemi.adapter

import android.os.Build.VERSION_CODES.N
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lloydsbanking_challenge_iniowofemi.R
import com.example.lloydsbanking_challenge_iniowofemi.databinding.InfoEntryBinding
import com.example.lloydsbanking_challenge_iniowofemi.model.Data
import com.squareup.picasso.Picasso

class InfoAdapter(
    private val mInfoList: MutableList<Data> = mutableListOf()
) : RecyclerView.Adapter<InfoViewHolder>(
) {

    fun setInfo(info: MutableList<Data>) {
        mInfoList.clear()
        mInfoList.addAll(info)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : InfoViewHolder =
        InfoViewHolder(
            InfoEntryBinding.inflate(
                LayoutInflater.from(parent.context ),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: InfoViewHolder, position: Int) =
        holder.bind(mInfoList[position])

    override fun getItemCount(): Int  = mInfoList.size

}

class InfoViewHolder (
    private val binding: InfoEntryBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(data: Data) {
        binding.animeTitle.text = data.attributes?.canonicalTitle ?: "Title N/A"
        binding.avgRating.text = binding.root.context.getString(R.string.avgRating, data.attributes?.averageRating ?:"Rating N/A")
        binding.ageRating.text = binding.root.context.getString(R.string.ageRating, data.attributes?.ageRating ?: "Age rating N/A")
        binding.synopsisFull.text = binding.root.context.getString(R.string.synopsis, data.attributes?.synopsis ?: "No synopsis available.")
    }
}