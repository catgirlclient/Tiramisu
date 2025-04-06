package live.shuuyu.discordinteraktions.platforms.jda.autocomplete

public fun interface AutocompleteExecutor<T> {
    public suspend fun execute(context: AutocompleteContext): Map<String, T>
}