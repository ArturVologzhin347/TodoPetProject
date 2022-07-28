package com.vologzhin.todopetproject.startup

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.runBlocking
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Service for organize steps while starting app. Steps doesn't support multithreading,
 * it intercepted by runBlocking.
 *
 * @see StartupStep
 */
internal class StartupService private constructor(private val steps: Array<StartupStep>) {

    /*
    Step by step, run the steps.
    Recommended use it in main Application class, in override fun onCreate()
    You can invoke this method only one once.
    */
    fun run(applicationContext: Context) = runBlocking {
        check(!appWasStarted.get()) {
            "App already started. Use Startup Service only once, while starting app"
        }

        steps.forEach {
            it.run(applicationContext)
        }

        appWasStarted.set(true)
    }

    companion object {
        private var appWasStarted = AtomicBoolean(false)

        /* Attention! Steps order matter! */
        fun fromSteps(vararg steps: StartupStep): StartupService {
            return StartupService(arrayOf(*steps))
        }
    }
}
