package com.aramzy.recyclingfacts

import android.app.Application
import com.twitter.sdk.android.core.Twitter

class myApplication: Application() {

    override fun onCreate() {

        super.onCreate()
        Twitter.initialize(this)

    }

}