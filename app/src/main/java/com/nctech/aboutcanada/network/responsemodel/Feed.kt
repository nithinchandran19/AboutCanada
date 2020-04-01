package com.nctech.aboutcanada.network.responsemodel

import com.google.gson.annotations.SerializedName

data class Feed (

    @SerializedName("title") val title : String,
    @SerializedName("rows") val rows : List<FeedDetails>
)