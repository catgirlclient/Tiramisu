package live.shuuyu.tiramisu.jda.request

import kotlinx.coroutines.future.await
import live.shuuyu.tiramisu.jda.messages.EditableMessage
import live.shuuyu.tiramisu.jda.messages.create.InteractionMessageCreateBuilder
import net.dv8tion.jda.api.interactions.callbacks.IReplyCallback
import net.dv8tion.jda.api.modals.Modal
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction

public class JDARequestManager(
    public val callback: IReplyCallback,
    bridge: RequestBridge
): RequestManager(bridge) {
    override suspend fun deferChannelMessage(ephemeral: Boolean): ReplyCallbackAction {
        return callback.deferReply(ephemeral)
    }

    override suspend fun sendMessage(
        message: InteractionMessageCreateBuilder
    ): EditableMessage {
        val messageData = message.toMessageCreateBuilder().build()

        return if (callback.isAcknowledged) {
            EditableMessage.FollowupInteractionMessage(
                callback.reply(messageData)
                    .setEphemeral(message.ephemeral)
                    .submit()
                    .await()
            )
        } else {
            EditableMessage.OriginalInteractionMessage(
                callback.hook.sendMessage(messageData)
                    .setEphemeral(message.ephemeral)
                    .submit()
                    .await()
            )
        }
    }

    override suspend fun sendModal(title: String, customId: String, builder: Modal.Builder.() -> (Unit)) {

    }
}