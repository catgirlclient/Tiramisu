import org.jetbrains.dokka.base.DokkaBase
import org.jetbrains.dokka.base.DokkaBaseConfiguration
import org.jetbrains.dokka.gradle.DokkaMultiModuleTask
import java.time.Year

plugins {
    id("org.jetbrains.dokka") version "2.0.0"
}

buildscript {
    dependencies {
        classpath("org.jetbrains.dokka:dokka-base:2.0.0")
    }
}

allprojects {
    tasks.withType<DokkaMultiModuleTask> {
        pluginConfiguration<DokkaBase, DokkaBaseConfiguration> {
            footerMessage = "© ${Year.now().value} Shuuyu"
        }
    }
}

