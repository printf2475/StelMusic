package com.template.convention

import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureCoilAndroid() {
    val libs = extensions.libs
    dependencies {
        "implementation"(libs.findLibrary("coil.compose").get())
        "implementation"(libs.findLibrary("coil.video").get())
        "implementation"(libs.findLibrary("coil.svg").get())
        "implementation"(libs.findLibrary("coil.gif").get())
    }
}