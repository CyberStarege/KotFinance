import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.core.domain"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.kotfinance.core.data)
            implementation(projects.kotfinance.core.model)
            implementation(libs.koin.bom)
            implementation(libs.koin.core)
            implementation(libs.kotlinx.coroutines.core)
        }
    }
}