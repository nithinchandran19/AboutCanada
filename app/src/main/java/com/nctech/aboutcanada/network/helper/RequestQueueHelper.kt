package com.nctech.aboutcanada.network.helper

import android.content.Context
import android.graphics.Bitmap
import android.util.LruCache
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.ImageLoader
import com.android.volley.toolbox.Volley

/**
 * Helper  singleton class that encapsulates RequestQueue and other Volley functionality
 */
class RequestQueueHelper constructor(context: Context) {

    companion object {

        @Volatile
        private var INSTANCE: RequestQueueHelper? = null
        fun getInstance(context: Context?) =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: context?.let {
                    RequestQueueHelper(it).also {
                        INSTANCE = it
                    }
                }
            }

    }

    val imageLoader: ImageLoader by lazy {
        ImageLoader(requestQueue,
            object : ImageLoader.ImageCache {
                private val cache = LruCache<String, Bitmap>(20)
                override fun getBitmap(url: String): Bitmap {
                    return cache.get(url)
                }

                override fun putBitmap(url: String, bitmap: Bitmap) {
                    cache.put(url, bitmap)
                }
            })
    }

    fun <T> addToRequestQueue(request: Request<T>) {
        requestQueue.add(request)
    }

    val requestQueue: RequestQueue by lazy {
        Volley.newRequestQueue(context)
    }
}