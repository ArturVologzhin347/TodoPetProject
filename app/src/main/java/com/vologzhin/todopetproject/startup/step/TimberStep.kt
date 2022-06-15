package com.vologzhin.todopetproject.startup.step

import android.content.Context
import com.vologzhin.todopetproject.BuildConfig
import com.vologzhin.todopetproject.startup.StartupStep
import timber.log.Timber

class TimberStep : StartupStep {

    override fun run(applicationContext: Context) {
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
