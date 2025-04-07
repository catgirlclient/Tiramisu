# Setting up your bot (Gateway)
> [!NOTE]
> This is assuming that you're running the bot through Discord's own gateway. If you're looking to using Kord with your
> own Ktor webserver, you may be interested in [the webserver article](bot-webserver.md).

## Creating and Initializing Your Bot

```kotlin
import live.shuuyu.discordinteraktions.common
import dev.kord.gateway.DefaultGateway
import live.shuuyu.discordinteraktions.platforms.kord.installDiscordInteraKTions

object Launcher {
    @JvmStatic
    fun main(args: Array<String>) {
        val gateway = DefaultGateway {}
        val token = System.getenv("TOKEN")
        val applicationId = System.getenv("APPLICATION_ID").toLong()
        val interactions = DiscordInteraKTions(token, applicationId)
        
        gateway.start(token)
        gateway.installDiscordInteraKTions(interactions)
    }
}
```

This does two main things:
1. This starts the Discord Gateway, which allows us to log in with the bot. This is the most important step, because your
bot will literally not be able to do anything if it's not active.
2. This allows for Discord InteraKTions to work and function, since we hook onto the Discord Gateway and send our interactions
through it.

