import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.hilt)
    alias(libs.plugins.template.android.room)
}

android {
    setNamespace("core.database")

    defaultConfig {
        testInstrumentationRunner = "com.template.core.database.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(libs.gson)
}