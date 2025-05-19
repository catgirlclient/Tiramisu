package live.shuuyu.discordinteraktions.common.commands

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent
import net.dv8tion.jda.api.interactions.Interaction

public open class GuildApplicationCommandContext (
    sender: User,
    channel: Channel,
    data: Interaction,
    discordInteraction: GenericInteractionCreateEvent,
    applicationCommandDeclaration: ApplicationCommandDeclaration,
    public val guild: Guild,
    public val member: Member
): ApplicationCommandContext(sender, channel, discordInteraction, applicationCommandDeclaration) {

}