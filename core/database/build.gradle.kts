plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidxRoom)
}

kotlin {

    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.core.database"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {
            implementation(projects.kotfinance.core.model)
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqlite.bundled)
            implementation(libs.kotlinx.datetime)
            implementation(project.dependencies.platform(libs.koin.bom))
            implementation(libs.koin.core)
        }

        androidMain.dependencies {
            implementation(libs.koin.android)
        }
    }
}

room {
    schemaDirectory("${rootProject.projectDir}/schemas")
}

dependencies {
    add("kspJvm", libs.androidx.room.compiler)
}