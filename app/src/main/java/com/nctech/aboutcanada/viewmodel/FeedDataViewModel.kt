package com.nctech.aboutcanada.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nctech.aboutcanada.network.helper.FeedAPIManager
import com.nctech.aboutcanada.network.helper.ResponseObserver
import com.nctech.aboutcanada.network.model.responsemodel.Feed

/**
 * View Model which fetches latest data and provides to UI
 */
class FeedDataViewModel : ViewModel() {

    var feedData: MutableLiveData<Feed> = MutableLiveData()
    var error: MutableLiveData<Exception> = MutableLiveData()

    fun getLatestData() {
        val observer = object : ResponseObserver {
            override fun onError(exception: Exception) {
                error.value = exception
            }

            override fun <T> onResponse(response: T) {
                feedData.value = response as Feed
            }

        }
        feedData = FeedAPIManager().getInstance().getLatestFeed(observer)
    }
}