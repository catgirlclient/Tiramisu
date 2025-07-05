package live.shuuyu.discordinteraktions.common.commands

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent

public open class GuildApplicationCommandContext (
    sender: User,
    channel: Channel,
    applicationCommandDeclaration: ApplicationCommandDeclaration,
    public val guild: Guild,
    public val member: Member,
    event: GenericCommandInteractionEvent,
): ApplicationCommandContext(sender, channel, applicationCommandDeclaration, event)