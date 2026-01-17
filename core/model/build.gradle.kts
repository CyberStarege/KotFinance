import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.model"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {

        }
    }
}