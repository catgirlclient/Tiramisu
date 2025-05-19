plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

group = "net.perfectdreams.discordinteraktions"

repositories {
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    api(project(":common:jda"))
    implementation(libs.jda)
    implementation(libs.coroutines.core)
    implementation(libs.serialization.json)
    implementation(libs.datetime)
}