package com.nctech.aboutcanada.network.responsemodel

import com.google.gson.annotations.SerializedName

data class FeedDetails(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageHref") val imageHref: String
)