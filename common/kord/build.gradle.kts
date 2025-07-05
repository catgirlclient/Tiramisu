plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

description = "Common files shared across Discord InteraKTions' Kord compatibility."

dependencies {
    api(project(":common:shared"))

    api(libs.kord.common)
    api(libs.kord.rest)
    api(libs.kord.core)

    implementation(libs.serialization.json)
    implementation(libs.coroutines.core)
    implementation(libs.kotlin.logging)
}