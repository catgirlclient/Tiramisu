@file:Suppress("UnstableApiUsage")

pluginManagement {
    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }

    repositories {
        mavenCentral()
        maven("https://maven.shuyu.me/releases")
        maven("https://maven.shuyu.me/snapshots")
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://maven.shuyu.me/releases")
        maven("https://maven.shuyu.me/snapshots")
    }
}

rootProject.name = "tiramisu"

include(":core")

