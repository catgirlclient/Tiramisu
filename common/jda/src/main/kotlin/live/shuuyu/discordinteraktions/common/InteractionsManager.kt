package live.shuuyu.discordinteraktions.common

import live.shuuyu.discordinteraktions.common.commands.*

public open class InteractionsManager {
    public val applicationCommandDeclarations: List<ApplicationCommandDeclaration> = mutableListOf()

    /**
     * The user command executors currently registered within the bot.
     *
     * @see UserCommandExecutor
     * @since 1.0.0
     */
    public val userCommandExecutors: List<UserCommandExecutor> = applicationCommandDeclarations
        .filterIsInstance<UserCommandDeclaration>().map { it.executor }

    /**
     * The slash command executors currently registered within the bot.
     *
     * @see SlashCommandExecutor
     * @since 1.0.0
     */
    public val slashCommandExecutors: List<SlashCommandExecutor> = applicationCommandDeclarations
        .filterIsInstance<SlashCommandDeclaration>().map { it.executor }


    /**
     * The message command executors currently registered within the bot
     *
     * @see MessageCommandExecutor
     * @since 1.0.0
     */
    public val messageCommandExecutor: List<MessageCommandExecutor> = applicationCommandDeclarations
        .filterIsInstance<MessageCommandDeclaration>().map { it.executor }


}