package live.shuuyu.tiramisu.jda.components

import live.shuuyu.tiramisu.common.components.ComponentExecutorDeclaration
import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class GuildComponentContext(
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    componentExecutorDeclaration: ComponentExecutorDeclaration,
    message: Message,
    dataOrNull: String?,
    public val guild: Guild,
    public val member: Member,
    event: GenericInteractionCreateEvent
): ComponentContext(bridge, sender, channel, componentExecutorDeclaration, message, dataOrNull, event) {

}