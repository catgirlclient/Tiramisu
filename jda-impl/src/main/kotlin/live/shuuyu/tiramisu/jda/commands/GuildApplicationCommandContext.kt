package live.shuuyu.tiramisu.jda.commands

import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class GuildApplicationCommandContext(
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    public val guild: Guild,
    public val member: Member,
    event: GenericInteractionCreateEvent,
): ApplicationCommandContext(bridge, sender, channel, event)