plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

dependencies {
    implementation(kotlin("stdlib"))
    api(project(":common"))
    implementation(libs.kord.rest)
    implementation(libs.kord.gateway)
}

tasks.test {
    useJUnitPlatform()
}