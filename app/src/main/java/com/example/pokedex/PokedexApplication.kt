package com.example.pokedex

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

/**
 * this basically marks our application class for dagger hilt , so that hilt has access to our
 * application context and things like that
 */
@HiltAndroidApp
class PokedexApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}