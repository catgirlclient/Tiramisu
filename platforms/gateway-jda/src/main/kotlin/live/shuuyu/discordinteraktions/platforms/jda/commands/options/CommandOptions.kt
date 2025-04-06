package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.OptionData

public interface InteraKTionsCommandOption<T> {
    public val name: String

    public fun register(): OptionData
}

public interface NameableCommandOption<T>: InteraKTionsCommandOption<T> {
    public val description: String
    public val nameLocalizations: Map<DiscordLocale, String>?
    public val descriptionLocalizations: Map<DiscordLocale, String>?
}

public interface DiscordCommandOption<T>: NameableCommandOption<T> {
    public val required: Boolean
}

public interface StringCommandOption: DiscordCommandOption<String> {
    public val lengthRange: IntRange?

    public override fun register(): OptionData {
        return OptionData(OptionType.STRING, name, description).apply {
            // Why do they do this?????
            setRequired(this@StringCommandOption.required)
            this@StringCommandOption.nameLocalizations?.let { setNameLocalizations(it) }
            this@StringCommandOption.descriptionLocalizations?.let { setDescriptionLocalizations(it) }
            this@StringCommandOption.lengthRange?.let { setRequiredLength(it.first, it.last) }

        }
    }
}