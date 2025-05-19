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
    ":common:jda",
    ":common:kord",
    ":common:shared",
    ":requests-verifier",
    ":platforms:gateway-jda",
    ":platforms:gateway-kord",
    ":platforms:webserver-ktor-kord",
    ":sample:gateway-jda",
    ":sample:gateway-kord",
    ":sample:webservers-ktor-kord"
)