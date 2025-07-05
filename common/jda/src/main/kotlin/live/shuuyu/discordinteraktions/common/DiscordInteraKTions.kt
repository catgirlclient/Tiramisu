package live.shuuyu.discordinteraktions.common

import live.shuuyu.discordinteraktions.common.commands.*
import live.shuuyu.discordinteraktions.common.commands.options.InteraKTionsCommandOption
import live.shuuyu.discordinteraktions.common.utils.JDACommandChecker
import live.shuuyu.discordinteraktions.common.utils.await
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.interactions.commands.build.*

public class DiscordInteraKTions(
    jda: JDABuilder,
    public val applicationId: Long
) {
    // Not intended for public use, since you'll most likely use your own.
    private val jda: JDA = jda.build()
    private val manager: InteractionsManager = InteractionsManager()
    private val commandChecker = JDACommandChecker(manager)

    /**
     * Upserts guild-related commands into the given server.
     *
     * @param guildId The ID of which you want to upsert the command into.
     *
     * @since 1.0.0
     */
    public suspend fun updateAllCommandsInGuild(guildId: Long) {
        val commands = jda.getGuildById(guildId)?.updateCommands() ?: error("The guild you've provided doesn't exist: $guildId!")

        commands.addCommands()
    }

    /**
     * Upserts commands to be used in all servers.
     *
     * @since 1.0.0
     */
    public suspend fun updateAllGlobalCommands() {
        val commands = jda.updateCommands()

        commands.addCommands()

        commands.await()
    }

    /**
     * Converts all command declarations into JDA commands to parse and upsert.
     *
     * @since 1.0.0
     */
    private fun convertAllCommandDeclarationsToJDA(declaration: ApplicationCommandDeclaration): CommandData {
        return when (declaration) {
            is MessageCommandDeclaration -> Commands.message(declaration.name).apply {
                declaration.nameLocalizations?.let { this.setNameLocalizations(it) }
                declaration.defaultMemberPermissions?.let { this.setDefaultPermissions(it) }
                declaration.contexts?.let { this.setContexts(it) }
                declaration.nsfw?.let { this.setNSFW(it) }
            }

            is UserCommandDeclaration -> Commands.user(declaration.name).apply {
                declaration.nameLocalizations?.let { this.setNameLocalizations(it) }
                declaration.defaultMemberPermissions?.let { this.setDefaultPermissions(it) }
                declaration.contexts?.let { this.setContexts(it) }
                declaration.nsfw?.let { this.setNSFW(it) }
            }

            is SlashCommandDeclaration -> Commands.slash(declaration.name, declaration.description).apply {
                declaration.nameLocalizations?.let { this.setNameLocalizations(it) }
                declaration.descriptionLocalizations?.let { this.setDescriptionLocalizations(it) }
                declaration.defaultMemberPermissions?.let { this.setDefaultPermissions(it) }
                declaration.contexts?.let { this.setContexts(it) }
                declaration.nsfw?.let { this.setNSFW(it) }

                if (declaration.subcommands.isNotEmpty() || declaration.subcommandGroups.isNotEmpty()) {
                    for (subCommand in declaration.subcommands) {
                        this.addSubcommands(convertSubcommandDeclarationToJDA(subCommand))
                    }

                    for (subCommandGroup in declaration.subcommandGroups) {
                        this.addSubcommandGroups(convertSubcommandGroupDeclarationToJDA(subCommandGroup))
                    }
                } else {
                    val executor = declaration.executor

                    require(executor != null) { "Subcommand cannot exist without a master command!" }

                    executor.options.registeredOptions.forEach {
                        convertCommandOptionsToJDA(it)
                    }
                }
            }

            is SlashCommandGroupDeclaration -> throw IllegalStateException("This should NEVER return as the conversion is only the root!")
        }
    }

    private fun convertSubcommandDeclarationToJDA(declaration: SlashCommandDeclaration): SubcommandData {
        val commandData = SubcommandData(declaration.name, declaration.description).apply {
            declaration.nameLocalizations?.let { setNameLocalizations(it) }
            declaration.descriptionLocalizations?.let { setDescriptionLocalizations(it) }
        }

        val executor = declaration.executor
        require(executor != null) { "Subcommand cannot exist without a master command!" }

        for (options in executor.options.registeredOptions) {
            convertCommandOptionsToJDA(options)
        }

        return commandData
    }

    private fun convertSubcommandGroupDeclarationToJDA(declaration: SlashCommandGroupDeclaration): SubcommandGroupData {
        val subCommandGroupData = SubcommandGroupData(declaration.name, declaration.description)

        for (subcommand in declaration.subcommands) {
            subCommandGroupData.addSubcommands(convertSubcommandDeclarationToJDA(subcommand))
        }

        return subCommandGroupData
    }

    private fun convertCommandOptionsToJDA(cmdOptions: InteraKTionsCommandOption<*>): OptionData = cmdOptions.register()
}

public fun DiscordInteraKTions(token: String, applicationId: Long): DiscordInteraKTions = DiscordInteraKTions(
    JDABuilder.createLight(token), // Caching should be configured by a user to user basis, not by us.
    applicationId
)