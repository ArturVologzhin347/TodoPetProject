package com.vologzhin.todopetproject.startup

import android.content.Context

internal interface StartupStep {

    /* Invoke when app starting */
    fun run(applicationContext: Context)
}
