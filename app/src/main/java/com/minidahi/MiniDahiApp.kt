package com.minidahi

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class MiniDahiApp : Application() {
    override fun onCreate() {
        super.onCreate()
        
        // Debug modda logging'i aktif et
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
} 