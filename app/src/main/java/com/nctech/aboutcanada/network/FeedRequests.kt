package com.nctech.aboutcanada.network

import androidx.lifecycle.MutableLiveData
import com.nctech.aboutcanada.network.model.responsemodel.Feed

/**
 * Constract for accessing APIs
 */
interface FeedRequests {
    fun getLatestFeed(): MutableLiveData<Feed>
}
