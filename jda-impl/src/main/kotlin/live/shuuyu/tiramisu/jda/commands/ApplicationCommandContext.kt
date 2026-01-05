package live.shuuyu.tiramisu.jda.commands

import live.shuuyu.tiramisu.jda.InteractionContext
import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class ApplicationCommandContext(
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    event: GenericInteractionCreateEvent,
): InteractionContext(bridge, sender, channel, event)