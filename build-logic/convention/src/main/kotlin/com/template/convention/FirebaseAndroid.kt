package com.template.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureFirebaseAndroid() {
    with(pluginManager) {
        apply("com.google.gms.google-services")
        apply("com.google.firebase.crashlytics")
    }

    val libs = extensions.libs
    dependencies {
        val bom = libs.findLibrary("firebase-bom").get()
        add("implementation", platform(bom))
        "implementation"(libs.findLibrary("firebase.analytics").get())
        "implementation"(libs.findLibrary("firebase.crashlytics").get())
    }
}