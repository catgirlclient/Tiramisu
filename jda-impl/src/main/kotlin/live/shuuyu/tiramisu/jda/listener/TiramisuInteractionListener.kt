package live.shuuyu.tiramisu.jda.listener

import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

public class TiramisuInteractionListener(): ListenerAdapter() {
    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        super.onSlashCommandInteraction(event)
    }

    override fun onUserContextInteraction(event: UserContextInteractionEvent) {
        super.onUserContextInteraction(event)
    }

    override fun onMessageContextInteraction(event: MessageContextInteractionEvent) {
        super.onMessageContextInteraction(event)
    }
}