package live.shuuyu.discordinteraktions.common.message

import net.dv8tion.jda.api.entities.Message.MentionType
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User


public class AllowedMentionsBuilder {
    public val roles: MutableSet<Role> = mutableSetOf()
    public val users: MutableSet<User> = mutableSetOf()
    public val types: MutableSet<MentionType> = mutableSetOf()

}