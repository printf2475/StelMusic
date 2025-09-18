package com.template.convention

import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import org.gradle.api.Project

enum class LocalProperty

enum class ManifestProperty

internal fun Project.configureDataAndroid() {
    androidExtension.apply {
        buildFeatures {
            buildConfig = true
        }

        flavorDimensions += "version"
        productFlavors {
            create("dev") { dimension = "version" }
            create("staging") { dimension = "version" }
            create("prod") { dimension = "version" }
        }
        defaultConfig {
            for (item in ManifestProperty.values()){
                val key = getApiKey(item.name)
                manifestPlaceholders[item.name] = key
            }

            for (item in LocalProperty.values()) {
                buildConfigField("String", item.name, getApiKey(item.name))
            }
        }
    }
}

fun Project.getApiKey(propertyKey: String): String {
    return gradleLocalProperties(rootDir, providers).getProperty(propertyKey)
}