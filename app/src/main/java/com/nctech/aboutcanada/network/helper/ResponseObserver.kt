package com.nctech.aboutcanada.network.helper

interface ResponseObserver {

    fun onError(exception: Exception)
    fun <T> onResponse(t: T)
}