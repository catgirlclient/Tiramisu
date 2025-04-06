plugins {
    id("live.shuuyu.discordinteraktions.convention")
    id("live.shuuyu.discordinteraktions.publishing")
}

dependencies {
    implementation(kotlin("reflect"))
    api(project(":requests-verifier"))
    api(project(":common"))
    implementation(libs.kord.rest)
    implementation(libs.ktor.server.netty)
}

tasks.test {
    useJUnitPlatform()
}