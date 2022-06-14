plugins {
    id("com.android.application") version "7.2.0" apply false
    id("com.android.library") version "7.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
    id("io.gitlab.arturbosch.detekt")
}

buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

detekt {
    parallel = true
    debug = false
    allRules = true
    config = files("$rootDir/.detekt/config.yml")
    ignoredBuildTypes = arrayListOf("release")
    basePath = projectDir.path
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
