package live.shuuyu.discordinteraktions.common.autocomplete

public fun interface AutocompleteExecutor<T> {
    public suspend fun execute(context: AutocompleteContext): Map<String, T>
}