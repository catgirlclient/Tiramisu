package live.shuuyu.discordinteraktions.platforms.jda.autocomplete

public fun interface AutocompleteHandler<T> {
    public suspend fun handle(context: AutocompleteContext, focusedOption: FocusedCommandOption): Map<String, T>
}