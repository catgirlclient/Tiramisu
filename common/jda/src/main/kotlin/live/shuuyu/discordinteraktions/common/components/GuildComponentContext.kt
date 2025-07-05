package live.shuuyu.discordinteraktions.common.components

import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent

public open class GuildComponentContext(
    sender: User,
    channel: Channel,
    componentExecutorDeclaration: ComponentExecutorDeclaration,
    message: Message,
    dataOrNull: String?,
    public val guild: Guild,
    public val member: Member,
    event: GenericComponentInteractionCreateEvent
): ComponentContext(sender, channel, componentExecutorDeclaration, message, dataOrNull, event) {

}