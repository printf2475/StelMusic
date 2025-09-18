package com.template.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureGooglePlayCoreAndroid() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("review").get())
        "implementation"(libs.findLibrary("review-ktx").get())
    }
}