package com.vologzhin.todopetproject.di

import com.vologzhin.todopetproject.MainActivity
import com.vologzhin.todopetproject.di.module.AppModule
import dagger.BindsInstance
import dagger.Component

@[
AppScope
Component(
    modules = [AppModule::class],
    dependencies = [AppDeps::class]
)
]
interface AppComponent {
    fun inject(activity: MainActivity)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appDeps(appDeps: AppDeps): Builder

        fun build(): AppComponent
    }
}
