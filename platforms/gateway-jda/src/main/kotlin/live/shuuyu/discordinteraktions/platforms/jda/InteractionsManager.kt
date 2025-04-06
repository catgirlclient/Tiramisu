package live.shuuyu.discordinteraktions.platforms.jda

import live.shuuyu.discordinteraktions.platforms.jda.commands.ApplicationCommandDeclaration
import live.shuuyu.discordinteraktions.platforms.jda.commands.UserCommandDeclaration
import live.shuuyu.discordinteraktions.platforms.jda.commands.UserCommandExecutor

public open class InteractionsManager {
    public val applicationCommandDeclarations: List<ApplicationCommandDeclaration> = mutableListOf()

    /**
     * The executors currently registered within the bot.
     *
     * @see UserCommandExecutor
     * @since 1.0.0
     */
    public val userCommandExecutors: List<UserCommandExecutor> =
        applicationCommandDeclarations.filterIsInstance<UserCommandDeclaration>().map { it.executor }

}