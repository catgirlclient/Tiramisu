plugins {
    id("live.shuuyu.tiramisu.convention")
    id("live.shuuyu.tiramisu.publishing")
}

dependencies {
    api(project(":common"))
    implementation(libs.bundles.kotlin)
    implementation(libs.jda)
    implementation(libs.kotlin.logging)
}