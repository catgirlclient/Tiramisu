package live.shuuyu.discordinteraktions.platforms.jda.listener

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import live.shuuyu.discordinteraktions.platforms.jda.DiscordInteraKTions
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
import net.dv8tion.jda.api.events.interaction.component.GenericComponentInteractionCreateEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

public class InteractionsListener(public val interaktions: DiscordInteraKTions): ListenerAdapter() {
    public companion object {
        private val logger = KotlinLogging.logger {  }
    }

    override fun onSlashCommandInteraction(event: SlashCommandInteractionEvent) {
        val executor = event.interaction.user
        val guild = event.interaction.guild

        GlobalScope.launch {

        }
    }

    override fun onUserContextInteraction(event: UserContextInteractionEvent) {
        val executor = event.interaction.user

        val targetUserId = event.target.id
        val targetAsMember = event.targetMember

        GlobalScope.launch {

        }
    }

    override fun onMessageContextInteraction(event: MessageContextInteractionEvent) {
        val executor = event.interaction.user

        val targetMessage = event.target

        GlobalScope.launch {

        }
    }

    override fun onGenericComponentInteractionCreate(event: GenericComponentInteractionCreateEvent) {
        super.onGenericComponentInteractionCreate(event)
    }
}