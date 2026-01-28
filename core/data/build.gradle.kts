plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
}

kotlin {
    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.data"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.kotfinance.core.model)
            implementation(projects.kotfinance.core.database)
            implementation(libs.kotlinx.coroutines.core)
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
        }
    }
}
