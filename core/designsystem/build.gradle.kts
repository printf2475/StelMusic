import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.library)
    alias(libs.plugins.stelmusic.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.model)
}