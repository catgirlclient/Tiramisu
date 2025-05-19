package live.shuuyu.discordinteraktions.common

public open class BarebonesInteractionContext(

) {
    private var wasInitiallyDeferredEphemerally: Boolean = false

    public suspend fun deferChannelMessage() {
        wasInitiallyDeferredEphemerally = false
    }
}