package live.shuuyu.discordinteraktions.platforms.jda.request

import RequestBridge

public abstract class RequestManager(public val bridge: RequestBridge) {
    public abstract suspend fun deferChannelMessage()
    public abstract suspend fun deferChannelMessageEphemerally()
    
}