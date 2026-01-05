package live.shuuyu.tiramisu

import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.invoke

plugins {
    id("java-library")
    `maven-publish`
}

tasks {
    configure<PublishingExtension>() {
        publications {
            register<MavenPublication>("maven") {
                from(components["java"])
                artifactId = project.name
                groupId = Project.Group
                version = Project.Version

                pom {
                    name = "Discord InteraKTions"
                    description = "Kotlin Library for Receiving and Handling Discord Interactions via Web Servers/Gateway with Kord."
                    url = Project.Url
                    packaging = "jar"

                    scm {
                        connection.set("scm:git:https://github.com/catgirlclient/DiscordInteraKTions.git")
                        developerConnection.set("scm:git:https://github.com/catgirlclient/DiscordInteraKTions.git")
                        url.set(Project.Url)
                    }

                    licenses {
                        license {
                            name.set("GNU Lesser General Public License Version 3.0")
                            url.set("https://www.gnu.org/licenses/lgpl-3.0.en.html")
                        }
                    }

                    developers {
                        developer {
                            name = "shuuyu"
                        }
                    }

                    issueManagement {
                        system = "GitHub"
                        url = "https://github.com/catgirlclient/DiscordInteraKTions/issues"
                    }
                }

                repositories {
                    val repoUser = project.findProject("reposilite.user")
                    val repoPassword = project.findProject("reposilite.password")

                    if (repoUser != null && repoPassword != null) {
                        maven("https://maven.shuuyu.live/releases") {
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