package live.shuuyu.discordinteraktions.platforms.jda.commands

import RequestBridge
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent
import net.dv8tion.jda.api.interactions.Interaction

public open class GuildApplicationCommandContext (
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    data: Interaction,
    discordInteraction: GenericInteractionCreateEvent,
    applicationCommandDeclaration: ApplicationCommandDeclaration,
    public val guild: Guild,
    public val member: Member
): ApplicationCommandContext(bridge, sender, channel, discordInteraction, applicationCommandDeclaration) {

}