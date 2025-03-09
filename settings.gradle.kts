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
        maven("https://repo.kord.dev/snapshots")
        maven("https://oss.sonatype.org/content/repositories/snapshots")
    }
}

rootProject.name = "DiscordInteraKTions"

include(
    ":bom",
    ":core",
    ":sample",
    ":common",
    ":requests-verifier",
    ":platforms:gateway-jda",
    ":platforms:gateway-kord",
    ":platforms:webserver-ktor-kord",
)