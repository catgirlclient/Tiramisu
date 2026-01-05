package live.shuuyu.tiramisu.jda.commands.executors

import live.shuuyu.tiramisu.common.commands.ApplicationCommandExecutor
import live.shuuyu.tiramisu.jda.commands.ApplicationCommandContext
import net.dv8tion.jda.api.entities.Message

public abstract class MessageCommandExecutor: ApplicationCommandExecutor() {
    public abstract suspend fun execute(context: ApplicationCommandContext, targetMessage: Message)
}