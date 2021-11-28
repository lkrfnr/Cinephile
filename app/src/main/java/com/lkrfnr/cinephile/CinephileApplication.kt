package com.lkrfnr.cinephile

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CinephileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}