package live.shuuyu.tiramisu.jda.components

import live.shuuyu.tiramisu.jda.components.declarations.SelectMenuExecutorDeclaration
import live.shuuyu.tiramisu.jda.messages.TiramisuActionRowBuilder
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@OptIn(ExperimentalContracts::class)
public fun TiramisuActionRowBuilder.channelSelect(
    executor: SelectMenuExecutorDeclaration,
    data: String,
    builder: TiramisuActionRowBuilder.ChannelSelectMenuBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    channelSelect("${executor.id}:$data", builder)
}

@OptIn(ExperimentalContracts::class)
public fun TiramisuActionRowBuilder.channelSelect(
    executor: SelectMenuExecutorDeclaration,
    builder: TiramisuActionRowBuilder.ChannelSelectMenuBuilder.() -> (Unit) = {}
) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    channelSelect(executor.id, builder)
}