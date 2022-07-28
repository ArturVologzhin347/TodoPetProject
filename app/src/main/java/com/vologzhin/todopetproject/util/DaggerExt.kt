package com.vologzhin.todopetproject.util

import android.content.Context
import com.vologzhin.todopetproject.App
import com.vologzhin.todopetproject.di.AppComponent

internal val Context.app: App
    get() = when (this) {
        is App -> this
        else -> this.applicationContext.app
    }

internal val Context.appComponent: AppComponent
    get() = app.appComponent
