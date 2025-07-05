package live.shuuyu.discordinteraktions.common.utils

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.*
import live.shuuyu.discordinteraktions.common.InteractionsManager
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.ApplicationCommandDeclaration
import live.shuuyu.discordinteraktions.common.commands.GuildApplicationCommandContext
import live.shuuyu.discordinteraktions.common.commands.SlashCommandDeclaration
import live.shuuyu.discordinteraktions.common.shared.commands.options.SlashCommandArguments
import net.dv8tion.jda.api.entities.Guild
import net.dv8tion.jda.api.entities.User
import net.dv8tion.jda.api.entities.channel.Channel
import net.dv8tion.jda.api.events.interaction.GenericInteractionCreateEvent
import net.dv8tion.jda.api.events.interaction.command.GenericCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.MessageContextInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent
import net.dv8tion.jda.api.events.interaction.command.UserContextInteractionEvent
import kotlin.coroutines.CoroutineContext

public class JDACommandChecker(public val interactionsManager: InteractionsManager) {
    public companion object: CoroutineScope {
        private val logger = KotlinLogging.logger {   }
        override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob() + CoroutineName(this::class.java.simpleName)
        private val scope = CoroutineScope(coroutineContext)
    }

    public fun checkAndExecute(event: GenericInteractionCreateEvent) {
        val sender = event.user
        val channel = event.channel
        val guild = event.guild

        when (event) {
            is SlashCommandInteractionEvent -> {
                val commandLabels = CommandDeclarationUtils.getSubcommandDeclarationNames(event)
                val command = CommandDeclarationUtils.getApplicationCommandDeclarationFromLabel<SlashCommandDeclaration>(interactionsManager, commandLabels)

                val executor = command?.executor ?: error("Missing a slash command executor!")

                val arguments = CommandDeclarationUtils.convertOptions(executor, event)

                scope.launch {
                    executor.execute(
                        createContext(
                            sender,
                            channel,
                            command,
                            guild,
                            event
                        ),
                        SlashCommandArguments(arguments)
                    )
                }
            }

            is UserContextInteractionEvent -> {
                scope.launch {

                }
            }

            is MessageContextInteractionEvent -> {
                scope.launch {

                }
            }
        }
    }

    private fun createContext(
        sender: User,
        channel: Channel?,
        applicationCommandDeclaration: ApplicationCommandDeclaration,
        guild: Guild?,
        event: GenericCommandInteractionEvent
    ): ApplicationCommandContext {
        return if (guild != null) {
            GuildApplicationCommandContext(
                sender,
                channel!!,
                applicationCommandDeclaration,
                guild,
                guild.getMemberById(sender.id)!!,
                event
            )
        } else {
            ApplicationCommandContext (
                sender,
                channel!!,
                applicationCommandDeclaration,
                event
            )
        }
    }
}