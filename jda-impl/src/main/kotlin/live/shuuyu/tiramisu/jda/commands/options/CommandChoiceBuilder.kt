package live.shuuyu.tiramisu.jda.commands.options

import net.dv8tion.jda.api.interactions.DiscordLocale

public class CommandChoiceBuilder<T>(
    public val name: String,
    public val value: T
) {
    public var nameLocalization: Map<DiscordLocale, String>? = null

    public fun build(): CommandChoice<T> = CommandChoice(
        name,
        value,
        nameLocalization
    )
}