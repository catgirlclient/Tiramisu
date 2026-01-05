package live.shuuyu.tiramisu.common.commands

import live.shuuyu.tiramisu.common.annotations.TiramisuInternal

// This is only internal since we need to implement the slash commands separately, and they share the same overarching
// command structure.
public open class ApplicationCommandExecutor {
    public open fun signature(): Any = this::class
}