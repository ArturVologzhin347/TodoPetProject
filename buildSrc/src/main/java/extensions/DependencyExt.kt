package extensions

import dependency.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.impl(dependency: Dependency) {
    add("implementation", dependency())
}

fun DependencyHandler.testImpl(dependency: Dependency) {
    add("testImplementation", dependency())
}

fun DependencyHandler.androidTestImpl(dependency: Dependency) {
    add("androidTestImplementation", dependency())
}

fun DependencyHandler.debugImpl(dependency: Dependency) {
    add("debugImplementation", dependency())
}

fun DependencyHandler.classpath(dependency: Dependency) {
    add("classpath", dependency())
}

fun DependencyHandler.impl(vararg dependency: Dependency) {
    dependency.forEach { impl(it) }
}

fun DependencyHandler.testImpl(vararg dependency: Dependency) {
    dependency.forEach { testImpl(it) }
}

fun DependencyHandler.androidTestImpl(vararg dependency: Dependency) {
    dependency.forEach { androidTestImpl(it) }
}

fun DependencyHandler.debugImpl(vararg dependency: Dependency) {
    dependency.forEach { debugImpl(it) }
}

fun DependencyHandler.classpath(vararg dependency: Dependency) {
    dependency.forEach { classpath(it) }
}

internal infix fun String.version(version: String): Dependency {
    return Dependency(this, version)
}
