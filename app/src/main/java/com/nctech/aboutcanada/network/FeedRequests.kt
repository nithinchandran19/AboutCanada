package com.nctech.aboutcanada.network

import androidx.lifecycle.MutableLiveData
import com.nctech.aboutcanada.network.helper.ResponseObserver
import com.nctech.aboutcanada.network.model.responsemodel.Feed

/**
 * Constract for accessing APIs
 */
interface FeedRequests {
    fun getLatestFeed(observer: ResponseObserver): MutableLiveData<Feed>
}
