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
  //  const val KTLINT = "0.45.2"
    const val SPOTLESS = "6.7.2"
    const val DETEKT = "1.21.0-RC1"
}


dependencies {

   // implementation("com.pinterest:ktlint:${PluginVersion.KTLINT}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginVersion.DETEKT}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${PluginVersion.SPOTLESS}")
}
