package live.shuuyu.tiramisu.jda.messages

import live.shuuyu.tiramisu.common.annotations.TiramisuDsl
import net.dv8tion.jda.api.components.actionrow.ActionRow
import net.dv8tion.jda.api.components.actionrow.ActionRowChildComponent
import net.dv8tion.jda.api.components.buttons.Button
import net.dv8tion.jda.api.components.buttons.ButtonStyle
import net.dv8tion.jda.api.components.selections.EntitySelectMenu
import net.dv8tion.jda.api.components.selections.SelectMenu
import net.dv8tion.jda.api.components.selections.SelectOption
import net.dv8tion.jda.api.components.selections.StringSelectMenu
import net.dv8tion.jda.api.entities.Role
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.entities.channel.ChannelType
import net.dv8tion.jda.api.entities.emoji.Emoji
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@TiramisuDsl
public open class TiramisuActionRowBuilder {
    public val components: MutableList<ActionRowChildComponent> = mutableListOf()

    @OptIn(ExperimentalContracts::class)
    public fun interactionButton(
        style: ButtonStyle,
        customId: String,
        builder: InteractionButtonBuilder.() -> Unit = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(InteractionButtonBuilder(style, customId).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public fun linkButton(
        url: String,
        label: String,
        builder: LinkButtonBuilder.() -> Unit = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(LinkButtonBuilder(url).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public inline fun premiumButton(
        skuId: String,
        builder: ButtonBuilder.() -> Unit = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(InteractionButtonBuilder(ButtonStyle.PREMIUM, skuId).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public inline fun stringSelect(
        customId: String,
        builder: StringSelectMenuBuilder.() -> (Unit) = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(StringSelectMenuBuilder(customId).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public inline fun userSelect(
        customId: String,
        builder: UserSelectMenuBuilder.() -> (Unit) = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(UserSelectMenuBuilder(customId).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public inline fun channelSelect(
        customId: String,
        builder: ChannelSelectMenuBuilder.() -> (Unit) = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(ChannelSelectMenuBuilder(customId).apply(builder).build())
    }

    @OptIn(ExperimentalContracts::class)
    public inline fun roleSelect(
        customId: String,
        builder: RoleSelectMenuBuilder.() -> (Unit) = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }

        components.add(RoleSelectMenuBuilder(customId).apply(builder).build())
    }

    public sealed class ButtonBuilder() {
        public var label: String = ""
        public var disabled: Boolean = false
        public var emoji: Emoji? = null

        public abstract fun build(): Button
    }

    @TiramisuDsl
    public class InteractionButtonBuilder(
        public var style: ButtonStyle,
        public var customId: String
    ): ButtonBuilder() {
        public override fun build(): Button = Button.of(style, customId, label).apply {
            withDisabled(this@InteractionButtonBuilder.disabled)
            withEmoji(this@InteractionButtonBuilder.emoji)
        }
    }

    @TiramisuDsl
    public class LinkButtonBuilder(public var url: String): ButtonBuilder() {
        override fun build(): Button = Button.link(url, label).apply {
            withDisabled(this@LinkButtonBuilder.disabled)
            withEmoji(this@LinkButtonBuilder.emoji)
        }
    }

    @TiramisuDsl
    public class SelectOptionBuilder(public val label: String, public val value: String) {
        public var description: String? = null
        public var emoji: Emoji? = null
        public var default: Boolean = false

        public fun build(): SelectOption = SelectOption.of(label, value).apply {
            description?.let { withDescription(it) }
            emoji?.let { withEmoji(emoji) }
            withDefault(default)
        }
    }

    public sealed class SelectMenuBuilder(public var customId: String) {
        public var options: MutableList<SelectOption> = mutableListOf()
        public var range: IntRange = 1..1
        public var placeholder: String = ""
        public var required: Boolean = true // Primarily for modals
        public var disabled: Boolean = false

        public inline fun SelectMenuBuilder.option(
            label: String,
            value: String,
            builder: SelectOptionBuilder.() -> Unit = {}
        ) {
            options.add(SelectOptionBuilder(label, value).apply(builder).build())
        }

        public abstract fun build(): SelectMenu
    }

    @TiramisuDsl
    public class StringSelectMenuBuilder(customId: String): SelectMenuBuilder(customId) {
        public var defaultValues: MutableList<String> = mutableListOf()

        public override fun build(): StringSelectMenu = StringSelectMenu.create(customId).apply {
            isDisabled = disabled
            addOptions(this@StringSelectMenuBuilder.options)
            setDefaultValues(defaultValues)
            setRequiredRange(range.first, range.last)
        }.build()
    }

    @TiramisuDsl
    public class UserSelectMenuBuilder(
        customId: String,
    ): SelectMenuBuilder(customId) {
        public var defaultUsers: MutableList<User> = mutableListOf()

        public override fun build(): EntitySelectMenu = EntitySelectMenu.create(
            customId,
            EntitySelectMenu.SelectTarget.USER
        ).apply {
            isDisabled = disabled
            setDefaultValues(defaultUsers.map { user -> EntitySelectMenu.DefaultValue.user(user.id) })
            setRequiredRange(range.first, range.last)
        }.build()
    }

    @TiramisuDsl
    public class ChannelSelectMenuBuilder(
        customId: String
    ): SelectMenuBuilder(customId) {
        public var defaultChannels: MutableList<Channel> = mutableListOf()
        public var channelTypes: MutableList<ChannelType> = mutableListOf()

        public override fun build(): EntitySelectMenu = EntitySelectMenu.create(
            customId,
            EntitySelectMenu.SelectTarget.CHANNEL
        ).apply {
            isDisabled = disabled
            setChannelTypes(channelTypes)
            setDefaultValues(defaultChannels.map { channel -> EntitySelectMenu.DefaultValue.channel(channel.id) })
            setRequiredRange(range.first, range.last)
        }.build()
    }

    @TiramisuDsl
    public class RoleSelectMenuBuilder(
        customId: String
    ): SelectMenuBuilder(customId) {
        public var defaultRoles: MutableList<Role> = mutableListOf()

        public override fun build(): EntitySelectMenu = EntitySelectMenu.create(
            customId,
            EntitySelectMenu.SelectTarget.ROLE
        ).apply {
            isDisabled = disabled
            setDefaultValues(defaultRoles.map { role -> EntitySelectMenu.DefaultValue.role(role.id) })
            setRequiredRange(range.first, range.last)
        }.build()
    }

    public fun build(): ActionRow = ActionRow.of(components)
}