plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

dependencies {
    api(project(":common:kord"))
    implementation(libs.kord.rest)
    implementation(libs.kord.gateway)
}