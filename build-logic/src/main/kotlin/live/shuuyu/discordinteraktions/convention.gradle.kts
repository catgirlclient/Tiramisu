package live.shuuyu.discordinteraktions

import kotlinx.validation.ApiValidationExtension
import kotlinx.validation.ExperimentalBCVApi
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    id("org.jetbrains.kotlinx.binary-compatibility-validator")
    signing
    java
}

group = Project.Group
version = Project.Version
description = Project.Description

repositories {
    mavenCentral()
    maven("https://repo.kord.dev/snapshots") // Fallback repository
    maven("https://m2.dv8tion.net/releases") // JDA repository
    maven("https://oss.sonatype.org/content/repositories/snapshots") // Main snapshot repository
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
}

@OptIn(ExperimentalBCVApi::class)
tasks {
    configure<JavaPluginExtension>() {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    configure<KotlinJvmProjectExtension>() {
        explicitApi()
        jvmToolchain(17) // latest supported LTS version

        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
            languageVersion.set(KotlinVersion.KOTLIN_2_0)
            progressiveMode = true
            freeCompilerArgs.add("-Xdont-warn-on-error-suppression")
        }
    }

    configure<ApiValidationExtension>() {
        nonPublicMarkers += "live.shuuyu.discordinteraktions.core.annotations.InteraKTionsInternal"
        klib.enabled = true
    }

    getByName<DokkaTask>("dokkaHtml") {
        moduleName.set("Discord InteraKTions")
        outputDirectory = rootDir.resolve("docs/api")

        dokkaSourceSets.configureEach {
            "main" {
                jdkVersion.set(17)
                suppressGeneratedFiles = true
                displayName.set("Discord InteraKTions")

                externalDocumentationLink("https://kotlinlang.org/")
                externalDocumentationLink("https://kord.dev/") // Kord's website
                externalDocumentationLink("https://jda.wiki/") // JDA's website
            }
        }
    }

    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}