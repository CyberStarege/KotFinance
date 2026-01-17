import com.android.build.api.dsl.androidLibrary

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.multiplatformLibrary)
    alias(libs.plugins.ksp)
    alias(libs.plugins.androidxRoom)
}

kotlin {

    jvm()

    androidLibrary {
        namespace = "com.cyberstarege.kotfinance.database"
        compileSdk = 36
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.androidx.room.runtime)
            implementation(libs.androidx.sqlite.bundled)
            implementation(libs.kotlinx.datetime)
        }
    }
}

room {
    schemaDirectory("${rootProject.projectDir}/schemas")
}

dependencies {
    add("kspJvm", libs.androidx.room.compiler)
}