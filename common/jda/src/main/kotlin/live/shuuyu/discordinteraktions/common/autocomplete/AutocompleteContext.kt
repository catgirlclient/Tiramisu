package live.shuuyu.discordinteraktions.common.autocomplete

import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.interactions.commands.build.OptionData

public class AutocompleteContext(
    sender: User,
    channel: Channel,
    public val arguments: List<OptionData>
)