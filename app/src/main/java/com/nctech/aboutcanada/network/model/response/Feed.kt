package com.nctech.aboutcanada.network.model.responsemodel

import com.google.gson.annotations.SerializedName

/**
 * Response data model class
 */
data class Feed(

    @SerializedName("title") val title: String,
    @SerializedName("rows") val rows: List<FeedDetails>
)