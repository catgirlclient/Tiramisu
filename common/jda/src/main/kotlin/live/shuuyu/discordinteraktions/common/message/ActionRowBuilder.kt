package live.shuuyu.discordinteraktions.common.message

import live.shuuyu.discordinteraktions.common.shared.annotations.InteraKTionsDsl
import net.dv8tion.jda.api.interactions.components.ActionRow
import net.dv8tion.jda.api.interactions.components.ItemComponent
import net.dv8tion.jda.api.interactions.components.buttons.Button
import net.dv8tion.jda.api.interactions.components.buttons.ButtonStyle
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

@InteraKTionsDsl
public class ActionRowBuilder {
    public val components: MutableList<ItemComponent> = mutableListOf()

    @OptIn(ExperimentalContracts::class)
    public inline fun interactionButton(
        style: ButtonStyle = ButtonStyle.SECONDARY,
        customId: String,
        builder: Button.() -> (Unit) = {}
    ) {
        contract {
            callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
        }
    }

    public fun build(): ActionRow {
        return ActionRow.of(components)
    }
}