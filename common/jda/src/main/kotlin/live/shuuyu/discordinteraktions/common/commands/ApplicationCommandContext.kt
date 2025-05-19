package live.shuuyu.discordinteraktions.common.commands

import live.shuuyu.discordinteraktions.common.InteractionContext
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class ApplicationCommandContext(
    sender: User,
    channel: Channel,
    discordInteraction: GenericInteractionCreateEvent,
    applicationCommandDeclaration: ApplicationCommandDeclaration
): InteractionContext(sender, channel, discordInteraction)