import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.ktor)
    alias(libs.plugins.template.android.hilt)
}

android {
    setNamespace("core.data")

    defaultConfig {
        testInstrumentationRunner = "com.template.core.data.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.database)
    implementation(projects.core.model)
    implementation(libs.kotlinx.serialization.json)
}