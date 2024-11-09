plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
}

dependencies {
    gradleApi()
    implementation(kotlin("stdlib"))
    implementation(kotlin("reflect"))
    implementation(libs.bundles.buildLogic)
}