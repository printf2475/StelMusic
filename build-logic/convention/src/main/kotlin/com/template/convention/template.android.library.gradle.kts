
import com.template.convention.configureKotlinAndroid
import com.template.convention.configureCoroutineAndroid
import com.template.convention.configureDataAndroid
import com.template.convention.libs
import gradle.kotlin.dsl.accessors._2fb5859a04200edaf14b854c40b2e363.android
import gradle.kotlin.dsl.accessors._2fb5859a04200edaf14b854c40b2e363.androidTestImplementation
import gradle.kotlin.dsl.accessors._2fb5859a04200edaf14b854c40b2e363.implementation
import org.gradle.kotlin.dsl.dependencies

plugins {
    id("com.android.library")
}

configureKotlinAndroid()
configureCoroutineAndroid()
configureDataAndroid()

android {
    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    val libs = project.extensions.libs
    implementation(libs.findLibrary("junit4").get())
    implementation(libs.findLibrary("androidx.runner").get())
    androidTestImplementation(libs.findLibrary("androidx.test.ext").get())
}