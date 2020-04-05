package com.nctech.aboutcanada.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nctech.aboutcanada.network.helper.FeedAPIManager
import com.nctech.aboutcanada.network.model.responsemodel.Feed

/**
 * View Model which fetches latest data and provides to UI
 */
class FeedDataViewModel : ViewModel() {

    var feedData: MutableLiveData<Feed> = MutableLiveData()

    fun getLatestData() {
        feedData = FeedAPIManager().getInstance().getLatestFeed()
    }
}