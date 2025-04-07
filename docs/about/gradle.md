# Installation

> [!WARNING]
> Discord InteraKTions requires Java 17 or higher during runtime in order to support its webserver features. If you don't
> know what JDK (Java Development Kit) to install, we recommend [Eclipse Temurin](https://adoptium.net/temurin/releases/?version=17).

If you don't know what build system to use, we personally recommend Gradle with Kotlin build script, since it's really
easy to configure and set up.

::: code-group

```kotlin [Gradle (Kotlin)]
repositories {
    mavenCentral() // For every other repository that we use
    maven("https://maven.shuyu.me/releases")
}

dependencies {
    // You should only pick ONE out of the three packages. 
    // We recommend JDA gateway for stability and ease of use.
    implementation("live.shuuyu.discordinteraktions:gateway-kord:1.0.0") // for kord-gateway
    implementation("live.shuuyu.discordinteraktions:gateway-jda:1.0.0") // for jda-gateway
    implementation("live.shuuyu.discordinteraktions:webserver-ktor-kord:1.0.0") // for kord-webserver
}
```

```groovy [Gradle (Groovy)]
repositories {
    maven {
        name "reposiliteRepository"
        url "https://maven.shuyu.me/releases"
    }
}

dependecies {
    // You should only pick ONE out of the three packages. 
    // We recommend JDA gateway for stability and ease of use.
    implementation "live.shuuyu.discordinteraktions:gateway-kord:1.0.0" // for kord-gateway
    implementation "live.shuuyu.discordinteraktions:gateway-jda:1.0.0" // for jda-gateway
    implementation "live.shuuyu.discordinteraktions:webserver-ktor-kord:1.0.0" // for kord-webserver
}
```

```xml [Maven]
<repositories>
    <id>reposilite-repository</id>
    <name>shuuyu moments</name>
    <url>https://maven.shuyu.me/releases</url>
</repositories>

<dependencies>
    <!--This is for the kord-gateway-->
    <dependency>
        <groupId>live.shuuyu.discordinteraktions</groupId>
        <artifactId>gateway-kord</artifactId>
        <version>1.0.0</version>
    </dependency>

    <!--This is for the kord-webserver-->
    <dependency>
        <groupId>live.shuuyu.discordinteraktions</groupId>
        <artifactId>gateway-jda</artifactId>
        <version>1.0.0</version>
    </dependency>

    <!--This is for the kord-webserver-->
    <dependency>
        <groupId>live.shuuyu.discordinteraktions</groupId>
        <artifactId>webserver-ktor-kord</artifactId>
        <version>1.0.0</version>
    </dependency>
</dependencies>
```

:::