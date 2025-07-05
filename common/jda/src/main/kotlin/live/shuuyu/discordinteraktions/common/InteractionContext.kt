package live.shuuyu.discordinteraktions.common

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent
import net.dv8tion.jda.api.events.interaction.command.GenericContextInteractionEvent

public open class InteractionContext(
    public val user: User,
    public val channel: Channel,

    // We call this if you don't have anything listed above
    public val discordInteraction: GenericInteractionCreateEvent
): BarebonesInteractionContext()