package live.shuuyu.discordinteraktions.platforms.jda.interactions

import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.Message.Attachment
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel

public class ResolvedObjects (
    public val channels: Map<Long, Channel>?,
    public val roles: Map<Long, Role>?,
    public val users: Map<Long, User>?,
    public val members: Map<Long, Member>?,
    public val messages: Map<Long, Message>?,
    public val attachments: Map<Long, Attachment>?
)