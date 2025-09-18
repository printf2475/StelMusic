import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.feature)
}

android {
    setNamespace("feature.home")
}