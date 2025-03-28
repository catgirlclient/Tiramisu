package live.shuuyu.discordinteraktions.platforms.jda

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel

public open class InteractionContext(
    public val user: User,
    public val channel: Channel
): BarebonesInteractionContext()