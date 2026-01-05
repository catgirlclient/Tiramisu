package live.shuuyu.tiramisu.common.components

public interface ComponentExecutor {
    public fun signature(): Any = this::class
}