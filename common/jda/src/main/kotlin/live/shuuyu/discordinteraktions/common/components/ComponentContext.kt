package live.shuuyu.discordinteraktions.common.components

import live.shuuyu.discordinteraktions.common.InteractionContext
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent

public open class ComponentContext(
    sender: User,
    channel: Channel,
    public val componentExecutorDeclaration: ComponentExecutorDeclaration,
    public val message: Message,
    public val dataOrNull: String?,
    interaction: GenericComponentInteractionCreateEvent
): InteractionContext(sender, channel, interaction) {
    public val data: String
        get() = dataOrNull ?: throw IllegalArgumentException()


}