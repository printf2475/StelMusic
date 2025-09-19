import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.feature)
}

android {
    setNamespace("feature.home")
}

dependencies{
    implementation(libs.androidx.paging.compose)
    implementation(libs.androidx.paging.runtime)
}