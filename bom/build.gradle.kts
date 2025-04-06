plugins {
    `java-platform`
    `maven-publish`
}

dependencies {
    constraints {
        rootProject.subprojects.forEach { subproject ->
            if (!subproject.plugins.hasPlugin("maven-publish") || subproject.name == name) return@forEach
            subproject.publishing.publications.withType<MavenPublication>().configureEach {
                api("$groupId:$artifactId:$version")
            }
        }
    }
}

publishing.publications.register<MavenPublication>("DiscordInteraKTions") {
    from(components["javaPlatform"])
}