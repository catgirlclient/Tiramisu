plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

description = "Common files shared across Discord InteraKTions' JDA compatibility."

dependencies {
    api(project(":common:shared"))

    api(libs.jda)

    implementation(libs.serialization.json)
    implementation(libs.coroutines.core)
    implementation(libs.kotlin.logging)
    implementation(libs.datetime)
}