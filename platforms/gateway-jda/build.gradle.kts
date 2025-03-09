plugins {
    live.shuuyu.scripts.`interaktions-module`
}

group = "net.perfectdreams.discordinteraktions"

repositories {
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    api(project(":core"))
    implementation(libs.jda)
    implementation(libs.coroutines.core)
    implementation(libs.serialization.json)
}