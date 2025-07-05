plugins {
    id("live.shuuyu.discordinteraktions.convention")
}

dependencies {
    implementation(libs.kord.common)
    implementation(libs.kord.core)
    implementation(libs.kord.rest)
    implementation(libs.kord.gateway)
}