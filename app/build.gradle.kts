import extensions.impl
import dependency.Dependencies
import extensions.androidTestImpl
import extensions.debugImpl
import extensions.testImpl

plugins {
    id(Plugin.ANDROID_APPLICATION)
    id(Plugin.ANDROID_KOTLIN)
}

android {
    compileSdk = Config.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = Config.APPLICATION_ID
        minSdk = Config.MIN_SDK_VERSION
        targetSdk = Config.TARGET_SDK_VERSION
        versionCode = Config.Version.CODE
        versionName = Config.Version.NAME

        testInstrumentationRunner = Config.Support.TEST_INSTRUMENTATION_RUNNER
        vectorDrawables {
            useSupportLibrary = Config.Support.SUPPORT_LIBRARY_VECTOR_DRAWABLES
        }
    }

    buildTypes {
        build.AppBuildType.ALL.forEach {
            getByName(it.name) {
                isDebuggable = it.isDebuggable
                isJniDebuggable = it.isJniDebuggable
                isMinifyEnabled = it.isMinifyEnabled
                isShrinkResources = it.isShrinkResources
                versionNameSuffix = it.versionNameSuffix
                applicationIdSuffix = it.applicationIdSuffix

                if (it.isMinifyEnabled) {
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    tasks.withType().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_11.toString()
            kotlinOptions.freeCompilerArgs += listOf(
                "-opt-in=kotlin.RequiresOptIn"
            )
        }
    }

    buildFeatures {
        compose = true
        dataBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = dependency.Version.COMPOSE
    }

    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    with(Dependencies) {
        impl(
            CORE_KTX,
            LIFECYCLE_RUNTIME,
            COMPOSE_UI,
            COMPOSE_MATERIAL,
            COMPOSE_PREVIEW,
            COMPOSE_ACTIVITY,
            STRICT,
            STRICT_KTX
        )
    }

    with(Dependencies.Test) {
        testImpl(
            JUNIT
        )
    }

    with(Dependencies.AndroidTest) {
        androidTestImpl(
            JUNIT_EXT,
            JUNIT_COMPOSE,
            ESPRESSO_CORE
        )
    }

    with(Dependencies.Debug) {
        debugImpl(
            COMPOSE_TOOLING,
            COMPOSE_MANIFEST
        )
    }
}
