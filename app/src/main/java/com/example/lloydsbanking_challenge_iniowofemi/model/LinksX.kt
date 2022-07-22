package com.example.lloydsbanking_challenge_iniowofemi.model


import com.google.gson.annotations.SerializedName

data class LinksX(
    @SerializedName("related")
    val related: String?,
    @SerializedName("self")
    val self: String?
)