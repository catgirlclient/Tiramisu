package live.shuuyu.scripts

import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    org.jetbrains.kotlin.jvm
    org.jetbrains.kotlin.plugin.serialization
    org.jetbrains.kotlinx.`binary-compatibility-validator`
    com.google.devtools.ksp
    org.jetbrains.dokka
    com.gradleup.shadow
    `maven-publish`
    signing
}

group = TiramisuProject.GROUP
version = TiramisuProject.VERSION

repositories {
    mavenCentral()
    maven("https://maven.shuyu.me/releases")
    maven("https://maven.shuyu.me/snapshots")
}

kotlin {
    explicitApi()
    jvmToolchain(17)

    compilerOptions {
        apiVersion.set(KotlinVersion.KOTLIN_2_0)
        languageVersion.set(KotlinVersion.KOTLIN_2_0)
        progressiveMode = true
        freeCompilerArgs.add("-Xdont-warn-on-error-suppression")
    }
}
