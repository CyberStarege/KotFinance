rootProject.name = "kotfinance"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        google()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":shared")
include(":core:data")
include(":core:database")
include(":core:model")
include(":feature:groups")
include(":core:domain")
include(":core:designsystem")
include(":androidApp")
include(":desktopApp")
