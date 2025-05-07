package live.shuuyu.discordinteraktions.platforms.jda.commands

import RequestBridge
import live.shuuyu.discordinteraktions.platforms.jda.InteractionContext
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class ApplicationCommandContext(
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    discordInteraction: GenericInteractionCreateEvent,
    applicationCommandDeclaration: ApplicationCommandDeclaration
): InteractionContext(sender, channel, discordInteraction)