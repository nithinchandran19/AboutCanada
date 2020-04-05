package com.nctech.aboutcanada.network.helper

import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.google.gson.Gson
import com.nctech.aboutcanada.network.FeedRequests
import com.nctech.aboutcanada.network.model.responsemodel.Feed

/**
 *  API manager class for fetching data from network layer
 */
class FeedAPIManager : FeedRequests {


    private val url = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/facts.json"
    private val liveData: MutableLiveData<Feed> = MutableLiveData()


    fun getInstance(): FeedAPIManager {
        return FeedAPIManager()
    }

    override fun getLatestFeed(): MutableLiveData<Feed> {
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                liveData.value = Gson().fromJson(response.toString(), Feed::class.java)

            },
            Response.ErrorListener { error ->
                error.message
            }
        )

        // Access the RequestQueue through your singleton class.
        RequestQueueHelper.getInstance(CoreManager.getContext())
            ?.addToRequestQueue(jsonObjectRequest)
        return liveData
    }
}