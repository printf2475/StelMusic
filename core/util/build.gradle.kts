import com.stelmusic.convention.setNamespace

plugins {
    alias(libs.plugins.stelmusic.android.library)
    alias(libs.plugins.stelmusic.android.compose)
}

android {
    setNamespace("core.util")
}

dependencies {
    api(libs.kotlinx.serialization.json)
    implementation(libs.utilcodex)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)

    // in app review
    implementation(libs.google.play.review)
    implementation(libs.google.play.review.ktx)
}