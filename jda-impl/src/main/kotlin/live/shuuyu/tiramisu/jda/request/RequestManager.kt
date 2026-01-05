package live.shuuyu.tiramisu.jda.request

import live.shuuyu.tiramisu.jda.messages.EditableMessage
import live.shuuyu.tiramisu.jda.messages.create.InteractionMessageCreateBuilder
import net.dv8tion.jda.api.modals.Modal
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction

public abstract class RequestManager(public val bridge: RequestBridge) {
    public abstract suspend fun deferChannelMessage(ephemeral: Boolean): ReplyCallbackAction

    public abstract suspend fun sendMessage(message: InteractionMessageCreateBuilder): EditableMessage

    public abstract suspend fun sendModal(title: String, customId: String, builder: Modal.Builder.() -> (Unit))
}