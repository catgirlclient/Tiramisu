package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import net.dv8tion.jda.api.interactions.DiscordLocale

public class CommandChoiceBuilder<T>(
    public val name: String,
    public val value: T
) {
    public var nameLocalizations: Map<DiscordLocale, String>? = null

    public fun build(): CommandChoice<T> = CommandChoice(
        name,
        value,
        nameLocalizations
    )
}