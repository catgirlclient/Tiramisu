package live.shuuyu.tiramisu.jda

import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

/**
 * Basic context for all interactions, since all context contain a channel, sender, and the firing event.
 *
 * @since 1.0.0
 */
public open class InteractionContext(
    bridge: RequestBridge,
    public val sender: User,
    public val channel: Channel,
    public open val event: GenericInteractionCreateEvent
): BarebonesInteractionContext(bridge)