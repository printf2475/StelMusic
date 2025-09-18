import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.library)
    alias(libs.plugins.stelmusic.android.ktor)
    alias(libs.plugins.stelmusic.android.hilt)
}

android {
    setNamespace("core.data")

    defaultConfig {
        testInstrumentationRunner = "com.stelmusic.core.data.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)
}