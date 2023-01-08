package com.mediaproject.rerollbag

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ReRollBagApp : Application() {
    companion object {

        private lateinit var application: ReRollBagApp

        fun getInstance() : ReRollBagApp = application

    }

    override fun onCreate(){
        super.onCreate()
        application = this
    }

}