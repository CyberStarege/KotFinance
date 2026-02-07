plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    dependencies {
        implementation(projects.kotfinance.composeApp)
        implementation(libs.androidx.activity.compose)
        implementation(libs.jetbrains.compose.ui.tooling.preview)
        debugImplementation(libs.jetbrains.compose.ui.tooling)
        implementation(libs.koin.core)
        implementation(libs.koin.android)
    }
}

android {
    namespace = "com.cyberstarege.kotfinance"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.cyberstarege.kotfinance"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}