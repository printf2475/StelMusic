package com.template.convention

import androidx.room.gradle.RoomExtension
import com.google.devtools.ksp.gradle.KspExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureRoomAndroid() {
    with(plugins) {
        apply("androidx.room")
        apply("com.google.devtools.ksp")
    }

    extensions.configure<KspExtension> {
        arg("room.generateKotlin", "true")
    }

    extensions.configure<RoomExtension> {
        schemaDirectory("$projectDir/schemas")
    }

    val libs = extensions.libs
    androidExtension.apply {
        dependencies {
            add( "implementation", libs.findLibrary("room.runtime").get())
            add( "ksp", libs.findLibrary("room.compiler").get())
            add( "annotationProcessor", libs.findLibrary("room.compiler").get())
            add( "implementation", libs.findLibrary("room.ktx").get())
        }
    }
}