package live.shuuyu.discordinteraktions.common.components

import dev.kord.common.entity.ButtonStyle
import dev.kord.rest.builder.component.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.channelSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: ChannelSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    channelSelect(
        "${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.channelSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: ChannelSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    channelSelect(executor.id, builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactiveButton(
    style: ButtonStyle,
    executor: ButtonExecutorDeclaration,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> (Unit)
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, executor.id, builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactionButton(
    style: ButtonStyle,
    label: String,
    executor: ButtonExecutorDeclaration,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(
        style,
        executor.id
    ) {
        this.label = label
        builder.invoke(this)
    }
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactionButton(
    style: ButtonStyle,
    executor: ButtonExecutorDeclaration,
    data: String,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> (Unit)
){
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, "${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactionButton(
    style: ButtonStyle,
    label: String,
    executor: ButtonExecutorDeclaration,
    data: String,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> Unit = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, "${executor.id}:$data", builder)
}

@Deprecated(
    "Renamed to interationButton",
    ReplaceWith("interactionButton(style, label, executor) { builder() }"),
    DeprecationLevel.ERROR
)
@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactiveButton(
    style: ButtonStyle,
    label: String,
    executor: ButtonExecutorDeclaration,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> Unit = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, executor.id, builder)
}

@Deprecated(
    "Renamed to interationButton",
    ReplaceWith("interactionButton(style, executor, data) { builder() }"),
    DeprecationLevel.ERROR
)
@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactiveButton(
    style: ButtonStyle,
    executor: ButtonExecutorDeclaration,
    data: String,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> Unit
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, "${executor.id}:$data", builder)
}

@Deprecated(
    "Renamed to interationButton",
    ReplaceWith("interactionButton(style, label, executor, data) { builder() }"),
    DeprecationLevel.ERROR
)
@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.interactiveButton(
    style: ButtonStyle,
    label: String,
    executor: ButtonExecutorDeclaration,
    data: String,
    builder: ButtonBuilder.InteractionButtonBuilder.() -> Unit = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    require(style != ButtonStyle.Link) { "You cannot use a ButtonStyle.Link style in a interactive button! Please use \"linkButton(...)\" if you want to create a button with a link" }

    interactionButton(style, "${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.mentionableSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: MentionableSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    mentionableSelect(executor.id, builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.mentionableSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: MentionableSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    mentionableSelect("${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.roleSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: RoleSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    roleSelect(executor.id, builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.roleSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: RoleSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    roleSelect("${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.stringSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: SelectMenuBuilder.() -> Unit = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    stringSelect(executor.id, builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.stringSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: SelectMenuBuilder.() -> Unit = {}
) {

    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    stringSelect("${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.userSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: UserSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    userSelect("${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun ActionRowBuilder.userSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: UserSelectBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    userSelect(executor, builder)
}