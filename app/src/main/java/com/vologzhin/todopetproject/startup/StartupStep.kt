package com.vologzhin.todopetproject.startup

import android.content.Context

internal interface StartupStep {

    /* Invoke when app starting */
    suspend fun run(applicationContext: Context)
}
