package com.template.convention

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureKtorAndroid() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("ktor.client.core").get())
        "implementation"(libs.findLibrary("ktor.client.okhttp").get())
        "implementation"(libs.findLibrary("ktor.client.serialization").get())
        "implementation"(libs.findLibrary("ktor.client.logging").get())
        "implementation"(libs.findLibrary("ktor.client.content.negotiation").get())
        "implementation"(libs.findLibrary("ktor.serialization.kotlinx.json").get())
    }
}

internal class KtorAndroidPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            configureHiltAndroid()
        }
    }
}