package com.vologzhin.todopetproject.startup.step

import android.content.Context
import com.kirillr.strictmodehelper.kotlin.dsl.initStrictMode
import com.vologzhin.todopetproject.BuildConfig
import com.vologzhin.todopetproject.startup.StartupStep

internal class StrictModeStep : StartupStep {

    override suspend fun run(applicationContext: Context) {
        initStrictMode(
            enable = BuildConfig.DEBUG,
            enableDefaults = false
        ) {
            threadPolicy {
                diskReads = true
                diskWrites = true
                network = true
                customSlowCalls = true
                unbufferedIo = true
                penalty { log = true } // TODO timber logging
            }

            vmPolicy {
                activityLeaks = true
                cleartextNetwork = true
                contentUriWithoutPermission = true
                fileUriExposure = true
                leakedClosableObjects = true
                leakedRegistrationObjects = true
                leakedSqlLiteObjects = true
                nonSdkApiUsage = true
                untaggedSockets = true
                credentialProtectedWhileLocked = true
                implicitDirectBoot = true
                penalty { log = true } // TODO timber logging
            }
        }
    }
}
