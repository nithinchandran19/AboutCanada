package com.nctech.aboutcanada.network.model.responsemodel

import com.google.gson.annotations.SerializedName

/**
 * Response data model class
 */
data class FeedDetails(
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("imageHref") val imageHref: String
)