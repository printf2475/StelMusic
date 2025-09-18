
import com.template.convention.configureHiltAndroid
import com.template.convention.configureCoilAndroid
import com.template.convention.libs
import gradle.kotlin.dsl.accessors._2fb5859a04200edaf14b854c40b2e363.android
import gradle.kotlin.dsl.accessors._2fb5859a04200edaf14b854c40b2e363.implementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

plugins {
    id("template.android.library")
    id("template.android.compose")
    id("kotlin-parcelize")
}

android {
    packaging {
        resources {
            excludes.add("META-INF/**")
        }
    }
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

configureHiltAndroid()
configureCoilAndroid()

dependencies {
    val libs = project.extensions.libs
    implementation(project(":core:util"))
    implementation(project(":core:domain"))
    implementation(project(":core:model"))


    implementation(libs.findLibrary("hilt.navigation.compose").get())
    implementation(libs.findLibrary("kotlinx.serialization.json").get())
    implementation(libs.findLibrary("orbit.compose").get())
    implementation(libs.findLibrary("orbit.core").get())
    implementation(libs.findLibrary("orbit.viewmodel").get())
}