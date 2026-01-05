package live.shuuyu.tiramisu.jda.components

import live.shuuyu.tiramisu.common.components.ComponentExecutorDeclaration
import live.shuuyu.tiramisu.jda.InteractionContext
import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent

public open class ComponentContext(
    bridge: RequestBridge,
    sender: User,
    channel: Channel,
    public val componentExecutorDeclaration: ComponentExecutorDeclaration,
    public val message: Message,
    public val dataOrNull: String?,
    event: GenericInteractionCreateEvent
): InteractionContext(bridge, sender, channel, event) {
    public val data: String = dataOrNull ?: error("There isn't any custom data present in this component context!")
}