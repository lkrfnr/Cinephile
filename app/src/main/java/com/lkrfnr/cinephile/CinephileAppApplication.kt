package com.lkrfnr.cinephile

import android.app.Application
import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CinephileAppApplication: Application(){
    override fun onCreate() {
        super.onCreate()
    }
}