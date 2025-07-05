package live.shuuyu.discordinteraktions.common.commands

import live.shuuyu.discordinteraktions.common.InteractionContext
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent

public open class ApplicationCommandContext(
    sender: User,
    channel: Channel,
    public val applicationCommandDeclaration: ApplicationCommandDeclaration,
    event: GenericCommandInteractionEvent,
): InteractionContext(sender, channel, event)