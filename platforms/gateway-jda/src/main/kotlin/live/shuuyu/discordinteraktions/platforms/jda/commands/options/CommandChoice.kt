package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import net.dv8tion.jda.api.interactions.DiscordLocale

public class CommandChoice<T> (
    public val name: String,
    public val value: T,
    public val nameLocalizations: Map<DiscordLocale, String>?
)