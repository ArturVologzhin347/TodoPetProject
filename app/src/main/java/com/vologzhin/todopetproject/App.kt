package com.vologzhin.todopetproject

import android.app.Application
import android.content.Context
import com.vologzhin.todopetproject.di.AppComponent
import com.vologzhin.todopetproject.di.AppDeps
import com.vologzhin.todopetproject.startup.StartupService
import com.vologzhin.todopetproject.startup.step.DaggerStep
import com.vologzhin.todopetproject.startup.step.StrictModeStep
import com.vologzhin.todopetproject.startup.step.TimberStep

class App : Application() {

    private var _appComponent: AppComponent? = null

    internal val appComponent: AppComponent
        get() = checkNotNull(_appComponent) {
            "Dagger not initialized"
        }

    override fun onCreate() {
        super.onCreate()

        // Run app!
        StartupService.fromSteps(
            TimberStep(),
            StrictModeStep(),
            DaggerStep(AppDepsImpl()) { _appComponent = it }
        ).run(this)
    }

    private inner class AppDepsImpl : AppDeps {
        override val context: Context = this@App
    }
}
