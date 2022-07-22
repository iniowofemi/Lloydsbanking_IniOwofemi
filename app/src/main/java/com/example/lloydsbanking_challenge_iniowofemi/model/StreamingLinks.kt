package com.example.lloydsbanking_challenge_iniowofemi.model


import com.google.gson.annotations.SerializedName

data class StreamingLinks(
    @SerializedName("links")
    val links: LinksX?
)