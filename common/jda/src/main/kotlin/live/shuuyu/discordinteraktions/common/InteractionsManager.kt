package live.shuuyu.discordinteraktions.common

import live.shuuyu.discordinteraktions.common.commands.*

public open class InteractionsManager {
    public val applicationCommandsDeclarations: MutableList<ApplicationCommandDeclaration> = mutableListOf()

    /**
     * The user command executors currently registered within the bot.
     *
     * @see UserCommandExecutor
     * @since 1.0.0
     */
    public val userCommandExecutors: List<UserCommandExecutor> = applicationCommandsDeclarations
        .filterIsInstance<UserCommandDeclaration>().map { it.executor }

    /**
     * The slash command executors currently registered within the bot.
     *
     * @see SlashCommandExecutor
     * @since 1.0.0
     */
    public val slashCommandExecutors: List<SlashCommandExecutor> = applicationCommandsDeclarations
        .filterIsInstance<SlashCommandDeclaration>()
        .flatMap {
            it.subcommands.map { it.executor } + it.subcommandGroups.flatMap { it.subcommands.map { it.executor } } + it.executor
        }
        .filterNotNull()

    /**
     * The message command executors currently registered within the bot
     *
     * @see MessageCommandExecutor
     * @since 1.0.0
     */
    public val messageCommandExecutor: List<MessageCommandExecutor> = applicationCommandsDeclarations
        .filterIsInstance<MessageCommandDeclaration>().map { it.executor }

    public fun register(declarationWrapper: SlashCommandDeclarationWrapper) {
        val builder = declarationWrapper.declaration()
        register(builder.build())
    }

    public fun register(declarationWrapper: MessageCommandDeclarationWrapper) {
        val builder = declarationWrapper.declaration()
        register(builder.build())
    }

    public fun register(declarationWrapper: UserCommandDeclarationWrapper) {
        val builder = declarationWrapper.declaration()
        register(builder.build())
    }

    public fun register(declaration: ApplicationCommandDeclaration) {
        // TODO: Validate if all executors of the command are present
        if (applicationCommandsDeclarations.any { it.name == declaration.name })
            error("There's already an root command registered with the label ${declaration.name}!")

        applicationCommandsDeclarations.add(declaration)
    }
}