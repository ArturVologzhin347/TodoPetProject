plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
    google()
}

object PluginVersion {
    const val DETEKT = "1.21.0-RC1"
}


dependencies {
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginVersion.DETEKT}")
}

