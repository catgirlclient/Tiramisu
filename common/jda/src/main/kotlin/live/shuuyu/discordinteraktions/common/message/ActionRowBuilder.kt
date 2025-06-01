package live.shuuyu.discordinteraktions.common.message

import live.shuuyu.discordinteraktions.common.shared.annotations.InteraKTionsDsl
import net.dv8tion.jda.api.interactions.components.ActionRow
import net.dv8tion.jda.api.interactions.components.ItemComponent

@InteraKTionsDsl
public class ActionRowBuilder {
    private val components: List<ItemComponent> = mutableListOf()

    public fun build(): ActionRow {
        return ActionRow.of(components)
    }
}