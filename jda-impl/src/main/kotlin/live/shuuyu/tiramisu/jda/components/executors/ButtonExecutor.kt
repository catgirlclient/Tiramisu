package live.shuuyu.tiramisu.jda.components.executors

import live.shuuyu.tiramisu.common.components.ComponentExecutor
import live.shuuyu.tiramisu.jda.components.ComponentContext
import net.dv8tion.jda.api.entities.User

public interface ButtonExecutor: ComponentExecutor {
    public suspend fun onClick(user: User, context: ComponentContext)
}