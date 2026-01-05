package live.shuuyu.tiramisu.jda.commands.executors

import live.shuuyu.tiramisu.common.commands.ApplicationCommandExecutor
import live.shuuyu.tiramisu.jda.commands.ApplicationCommandContext
import live.shuuyu.tiramisu.jda.commands.options.ApplicationCommandOptions

public abstract class SlashCommandExecutor: ApplicationCommandExecutor() {
    public abstract suspend fun execute(context: ApplicationCommandContext, options: ApplicationCommandOptions)
}