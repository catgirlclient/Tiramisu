package live.shuuyu.tiramisu.jda.components.executors

import live.shuuyu.tiramisu.common.components.ComponentExecutor
import live.shuuyu.tiramisu.jda.components.ComponentContext
import net.dv8tion.jda.api.entities.User

public interface SelectMenuExecutor: ComponentExecutor {
    public suspend fun onSelect(user: User, context: ComponentContext, values: List<String>)
}