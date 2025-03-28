package live.shuuyu.discordinteraktions.platforms.jda

public open class BarebonesInteractionContext(

) {
    private var wasInitiallyDeferredEphemerally: Boolean = false

    public suspend fun deferChannelMessage() {
        wasInitiallyDeferredEphemerally = false
    }
}