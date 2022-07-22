package com.example.lloydsbanking_challenge_iniowofemi.model


import com.google.gson.annotations.SerializedName

data class AnimeResponse(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("links")
    val links: LinksXXXXXXXXXXXXXXXXX?,
    @SerializedName("meta")
    val meta: MetaXX?
)