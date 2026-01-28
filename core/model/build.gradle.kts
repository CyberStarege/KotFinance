plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.core.model"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {
        }
    }
}