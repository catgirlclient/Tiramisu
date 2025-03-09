package live.shuuyu.discordinteraktions

plugins {
    id("java-library")
    `maven-publish`
}

tasks {
    configure<PublishingExtension>() {
        publications {
            register<MavenPublication>("maven") {
                from(components["java"])

                repositories {
                    val repoUser = project.findProject("reposilite.user")
                    val repoPassword = project.findProject("reposilite.password")

                    if (repoUser != null && repoPassword != null) {
                        maven("https://maven.shuyu.me/releases") {
                            name = "reposilite-public"
                            credentials {
                                username = repoUser.toString()
                                password = repoPassword.toString()
                            }
                        }
                    }
                }
            }
        }
    }
}