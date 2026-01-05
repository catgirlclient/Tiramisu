@file:OptIn(ExperimentalAbiValidation::class)

package live.shuuyu.tiramisu

import org.gradle.kotlin.dsl.invoke
import org.jetbrains.dokka.gradle.DokkaExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.dsl.abi.ExperimentalAbiValidation

plugins {
    kotlin("jvm")
    kotlin("plugin.serialization")
    id("org.jetbrains.dokka")
    signing
    java
}

group = Project.Group
version = Project.Version
description = Project.Description

repositories {
    mavenCentral()
    maven("https://snapshots.kord.dev") // Fallback repository
    maven("https://m2.dv8tion.net/releases") // JDA repository
    maven("https://oss.sonatype.org/content/repositories/snapshots") // Main snapshot repository
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
}

tasks {
    configure<JavaPluginExtension>() {
        toolchain.languageVersion.set(JavaLanguageVersion.of(17))
    }

    configure<KotlinJvmProjectExtension>() {
        explicitApi()
        jvmToolchain(17) // latest supported LTS version

        abiValidation {
            enabled.set(true)
            filters {
                excluded {
                    byNames.add("**.TiramisuAnnotations")
                    annotatedWith.add("live.shuuyu.tiramisu.common.annotation.TiramisuInternal")
                }
            }
        }

        compilerOptions {
            apiVersion.set(KotlinVersion.KOTLIN_2_0)
            languageVersion.set(KotlinVersion.KOTLIN_2_0)
            progressiveMode = true
            freeCompilerArgs.add("-Xdont-warn-on-error-suppression")
        }
    }

    configure<DokkaExtension>() {
        moduleName.set("DiscordInteraKTions")

        dokkaPublications.html {
            outputDirectory.set(file("docs/api"))
        }

        dokkaSourceSets.configureEach {
            "main" {
                jdkVersion.set(17)
                suppressGeneratedFiles = true
                displayName.set("Discord InteraKTions")

                externalDocumentationLinks.create("https://kotlinlang.org/")
                externalDocumentationLinks.create("https://kord.dev/") // Kord's website
                externalDocumentationLinks.create("https://jda.wiki/") // JDA's website
            }
        }
    }

    withType<Test>().configureEach {
        useJUnitPlatform()
    }
}