package live.shuuyu.discordinteraktions.platform.jda

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.requests.restaction.CommandListUpdateAction

public class JDADiscordInteraKTions(
    public val jda: JDA,
    public val applicationId: Long
) {
    public suspend fun updateAllCommandsInGuild(guildId: Long): CommandListUpdateAction =
        jda.getGuildById(guildId)?.updateCommands() ?: error("There doesn't seem to be a guild with the ID: $guildId!")

    public fun updateAllGlobalCommands(): CommandListUpdateAction = jda.updateCommands()

    private fun convertAllCommandDeclarationsToJDA() {

    }
}