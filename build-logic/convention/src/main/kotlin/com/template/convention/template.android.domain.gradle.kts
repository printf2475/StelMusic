
import com.template.convention.configureKotlinAndroid
import gradle.kotlin.dsl.accessors._4b055a01bae563bd2c86a468691a3401.implementation
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project


plugins {
    id("template.android.library")
}

configureKotlinAndroid()

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:model"))
}