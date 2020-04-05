package com.nctech.aboutcanada.network.helper

import android.content.Context

/**
 * Core manager class for holding all core things of app
 */
open class CoreManager {

    companion object {

        private var INSTANCE: CoreManager? = null

        fun getInstance(): CoreManager? {
            if (INSTANCE == null) {
                INSTANCE = CoreManager()
            }
            return INSTANCE
        }

        fun getContext(): Context? {
            return mContext
        }

        private var mContext: Context? = null
    }


    fun init(context: Context) {
        mContext = context
    }


}