package com.vologzhin.todopetproject.di.module

import android.content.Context
import com.vologzhin.todopetproject.R
import com.vologzhin.todopetproject.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @[Provides AppScope]
    fun provideTestThing(context: Context) = context.getString(R.string.app_name)
}
