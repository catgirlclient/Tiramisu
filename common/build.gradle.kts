plugins {
    id("live.shuuyu.tiramisu.convention")
    id("live.shuuyu.tiramisu.publishing")
}

dependencies {
    implementation(libs.bundles.kotlin)
    implementation(libs.kotlin.logging)
}