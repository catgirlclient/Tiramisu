package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import live.shuuyu.discordinteraktions.platforms.jda.autocomplete.AutocompleteHandler
import net.dv8tion.jda.api.entities.Mentions
import net.dv8tion.jda.api.entities.Message.Attachment
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.entities.channel.ChannelType
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.commands.OptionMapping
import net.dv8tion.jda.api.interactions.commands.OptionType
import net.dv8tion.jda.api.interactions.commands.build.OptionData

public interface InteraKTionsCommandOption<T> {
    public val name: String

    public fun register(): OptionData
    public fun parse(option: OptionMapping): T?
}

public interface NameableCommandOption<T>: InteraKTionsCommandOption<T> {
    public val description: String
    public val nameLocalizations: Map<DiscordLocale, String>?
    public val descriptionLocalizations: Map<DiscordLocale, String>?
}

public interface DiscordCommandOption<T>: NameableCommandOption<T> {
    public val required: Boolean
}

public interface ChoiceableCommandOption<T> {
    public val choices: List<CommandChoice<T>>?
    public val autocompleteExecutor: AutocompleteHandler<T>?
}

public interface StringCommandOption: DiscordCommandOption<String>, ChoiceableCommandOption<String> {
    public val minLength: Int?
    public val maxLength: Int?

    public override fun register(): OptionData = OptionData(OptionType.STRING, name, description).apply {
        with(this@StringCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
            setAutoComplete(this@StringCommandOption.autocompleteExecutor != null)
            minLength?.let { setMinLength(it) }
            maxLength?.let { setMaxLength(it) }

            choices?.forEach { choice ->
                addChoice(choice.name, choice.value)
            }
        }
    }

    override fun parse(option: OptionMapping): String? {
        return option.asString
    }
}

public data class DefaultStringCommandOption(
    override val name: String,
    override val minLength: Int?,
    override val maxLength: Int?,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?,
    override val choices: List<CommandChoice<String>>?,
    override val autocompleteExecutor: AutocompleteHandler<String>?
): StringCommandOption

public interface IntegerCommandOption: DiscordCommandOption<Long>, ChoiceableCommandOption<Long> {
    public val minValue: Long?
    public val maxValue: Long?

    override fun register(): OptionData = OptionData(OptionType.INTEGER, name, description).apply {
        with(this@IntegerCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
            setAutoComplete(autocompleteExecutor != null)
            minValue?.let { setMinValue(it) }
            maxValue?.let { setMaxValue(it) }

            choices?.forEach { choice ->
                addChoice(choice.name, choice.value)
            }
        }
    }

    override fun parse(option: OptionMapping): Long? {
        return option.asLong
    }
}

public data class DefaultIntegerCommandOption(
    override val name: String,
    override val minValue: Long?,
    override val maxValue: Long?,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?,
    override val choices: List<CommandChoice<Long>>?,
    override val autocompleteExecutor: AutocompleteHandler<Long>?
): IntegerCommandOption

public interface NumberCommandOption: DiscordCommandOption<Double>, ChoiceableCommandOption<Double> {
    public val minValue: Double?
    public val maxValue: Double?

    override fun register(): OptionData = OptionData(OptionType.NUMBER, name, description).apply {
        with(this@NumberCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap())}
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
            setAutoComplete(autocompleteExecutor != null)
            minValue?.let { setMinValue(it) }
            maxValue?.let { setMaxValue(it) }

            choices?.forEach { choice ->
                addChoice(choice.name, choice.value)
            }
        }
    }

    override fun parse(option: OptionMapping): Double? {
        return option.asDouble
    }
}

public data class DefaultNumberCommandOption(
    override val name: String,
    override val minValue: Double?,
    override val maxValue: Double?,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?,
    override val choices: List<CommandChoice<Double>>?,
    override val autocompleteExecutor: AutocompleteHandler<Double>?
): NumberCommandOption

public interface BooleanCommandOption: DiscordCommandOption<Boolean> {
    override fun register(): OptionData = OptionData(OptionType.BOOLEAN, name, description).apply {
        with(this@BooleanCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
        }
    }

    override fun parse(option: OptionMapping): Boolean? {
        return option.asBoolean
    }
}

public data class DefaultBooleanCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?
): BooleanCommandOption

public interface UserCommandOption: DiscordCommandOption<User> {
    override fun register(): OptionData = OptionData(OptionType.USER, name, description).apply {
        with(this@UserCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
        }
    }

    override fun parse(option: OptionMapping): User? {
        return option.asUser
    }
}

public data class DefaultUserCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?
): UserCommandOption

public interface RoleCommandOption: DiscordCommandOption<Role> {
    override fun register(): OptionData = OptionData(OptionType.ROLE, name, description).apply {
        with(this@RoleCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
        }
    }

    override fun parse(option: OptionMapping): Role? {
        return option.asRole
    }
}

public data class DefaultRoleCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?
): RoleCommandOption

public interface ChannelCommandOption: DiscordCommandOption<Channel> {
    public val channelTypes: List<ChannelType>?

    override fun register(): OptionData = OptionData(OptionType.CHANNEL, name, description).apply {
        with(this@ChannelCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it) }
            channelTypes?.let { setChannelTypes(it) }
        }
    }

    override fun parse(option: OptionMapping): Channel? {
        return option.asChannel
    }
}

public data class DefaultChannelCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?,
    override val channelTypes: List<ChannelType>?
): ChannelCommandOption

public interface MentionableCommandOption: DiscordCommandOption<Mentions> {
    override fun register(): OptionData = OptionData(OptionType.MENTIONABLE, name, description).apply {
        with(this@MentionableCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
        }
    }

    override fun parse(option: OptionMapping): Mentions? {
        return option.mentions
    }
}

public data class DefaultMentionableCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?
): MentionableCommandOption

public interface AttachmentCommandOption: DiscordCommandOption<Attachment> {
    override fun register(): OptionData = OptionData(OptionType.ATTACHMENT, name, description).apply {
        with(this@AttachmentCommandOption) {
            setRequired(required)
            nameLocalizations?.let { setNameLocalizations(it.toMutableMap()) }
            descriptionLocalizations?.let { setDescriptionLocalizations(it.toMutableMap()) }
        }
    }

    override fun parse(option: OptionMapping): Attachment? {
        return option.asAttachment
    }
}

public data class DefaultAttachmentCommandOption(
    override val name: String,
    override val required: Boolean,
    override val description: String,
    override val nameLocalizations: Map<DiscordLocale, String>?,
    override val descriptionLocalizations: Map<DiscordLocale, String>?
): AttachmentCommandOption