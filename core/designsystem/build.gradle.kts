import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose)
}

android {
    setNamespace("core.designsystem")
}

dependencies {
    implementation(projects.core.util)
    implementation(projects.core.model)
}