import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
}

android {
    setNamespace("core.model")
}

dependencies {
    api(projects.core.util)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.runtime.android)
}