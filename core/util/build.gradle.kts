import com.template.convention.setNamespace

plugins {
    alias(libs.plugins.template.android.library)
    alias(libs.plugins.template.android.compose)
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