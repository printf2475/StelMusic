import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.feature)
}

android {
    setNamespace("feature.home")
}