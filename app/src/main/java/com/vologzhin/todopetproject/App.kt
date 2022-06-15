package com.vologzhin.todopetproject

import android.app.Application
import com.vologzhin.todopetproject.startup.StartupService
import com.vologzhin.todopetproject.startup.step.StrictModeStep
import com.vologzhin.todopetproject.startup.step.TimberStep

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // Run app!
        StartupService.fromSteps(
            TimberStep(),
            StrictModeStep()
        ).run(this)
    }
}
