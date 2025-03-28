package live.shuuyu.discordinteraktions.platforms.jda

import live.shuuyu.discordinteraktions.platforms.jda.utils.await
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

public class DiscordInteraKTions(
    jda: JDABuilder,
    public val applicationId: Long
) {
    // Not intended for public use, since you'll most likely use your own.
    private val jda: JDA = jda.build()

    /**
     * Upserts guild-related commands into the given server.
     *
     * @param guildId The ID of which you want to upsert the command into.
     *
     * @since 1.0.0
     */
    public suspend fun updateAllCommandsInGuild(guildId: Long) {
        val commands = jda.getGuildById(guildId)?.updateCommands() ?: error("The guild you've provided doesn't exist: $guildId!")

        commands.addCommands()
    }

    /**
     * Upserts commands to be used in all servers.
     *
     * @since 1.0.0
     */
    public suspend fun updateAllGlobalCommands() {
        val commands = jda.updateCommands()

        commands.addCommands()

        commands.await()
    }

    private fun convertAllCommandDeclarationsToJDA() {

    }
}

public fun DiscordInteraKTions(token: String, applicationId: Long): DiscordInteraKTions = DiscordInteraKTions(
    JDABuilder.createLight(token),
    applicationId
)