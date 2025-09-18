import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.hilt)
}

android {
    setNamespace("core.domain")

    defaultConfig {
        testInstrumentationRunner = "com.template.core.domain.CustomTestRunner"
    }
}

dependencies {
    implementation(projects.core.model)
    implementation(projects.core.data)
    implementation(libs.inject)
}