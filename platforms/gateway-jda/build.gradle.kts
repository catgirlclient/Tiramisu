plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

dependencies {
    api(project(":common:jda"))
    implementation(libs.jda)
    implementation(libs.coroutines.core)
    implementation(libs.serialization.json)
    implementation(libs.datetime)
}