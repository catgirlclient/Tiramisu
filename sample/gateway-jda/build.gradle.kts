plugins {
    kotlin("jvm") version "2.1.20"
}

dependencies {
    implementation(project(":platforms:gateway-jda"))
    implementation(libs.jda)
}