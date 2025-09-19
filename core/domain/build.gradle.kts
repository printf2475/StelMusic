import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.library)
    alias(libs.plugins.stelmusic.android.hilt)
}

android {
    setNamespace("core.domain")

    defaultConfig {
        testInstrumentationRunner = "com.stelmusic.core.domain.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.inject)
    implementation(libs.androidx.paging.common)
}