@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")

    plugins {
        id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
    }

    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
        maven("https://snapshots.kord.dev/")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "Tiramisu"


include(
    ":common",
    ":jda-impl",
    ":kord-impl"
)