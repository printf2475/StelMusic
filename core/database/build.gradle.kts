import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.library)
    alias(libs.plugins.stelmusic.android.hilt)
    alias(libs.plugins.stelmusic.android.room)
}

android {
    setNamespace("core.database")

    defaultConfig {
        testInstrumentationRunner = "com.stelmusic.core.database.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.gson)
}