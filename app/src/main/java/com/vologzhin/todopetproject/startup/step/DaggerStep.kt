package com.vologzhin.todopetproject.startup.step

import android.content.Context
import com.vologzhin.todopetproject.di.AppComponent
import com.vologzhin.todopetproject.di.AppDeps
import com.vologzhin.todopetproject.di.DaggerAppComponent
import com.vologzhin.todopetproject.startup.StartupStep

class DaggerStep(
    private val appDeps: AppDeps,
    private val callback: (appComponent: AppComponent) -> Unit
) : StartupStep {

    override suspend fun run(applicationContext: Context) {
        DaggerAppComponent.builder()
            .appDeps(appDeps)
            .build()
            .also(callback::invoke)
    }
}
