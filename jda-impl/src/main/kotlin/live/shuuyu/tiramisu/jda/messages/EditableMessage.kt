package live.shuuyu.tiramisu.jda.messages

import kotlinx.coroutines.future.await
import live.shuuyu.tiramisu.jda.messages.modify.InteractionMessageModifyBuilder
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.interactions.InteractionHook

public interface EditableMessage {
    /**
     * Returns the message which was sent, either the followup or original message.
     *
     * @since 1.0.0
     */
    public suspend fun originalMessage(): Message

    public suspend fun editMessage(builder: InteractionMessageModifyBuilder.() -> (Unit)): Message

    /**
     * Deletes the message associated.
     *
     * @since 1.0.0
     */
    public suspend fun deleteMessage()

    public class OriginalInteractionMessage(public val message: Message): EditableMessage {
        override suspend fun originalMessage(): Message = message

        override suspend fun editMessage(builder: InteractionMessageModifyBuilder.() -> (Unit)): Message {
            val newMessage = InteractionMessageModifyBuilder().apply(builder).toMessageEditBuilder()

            return message.editMessage(newMessage.build()).submit().await()
        }

        override suspend fun deleteMessage() {
            message.delete().submit().await()
        }
    }

    public class FollowupInteractionMessage(public val hook: InteractionHook): EditableMessage {
        override suspend fun originalMessage(): Message = hook.retrieveOriginal().submit().await()

        override suspend fun editMessage(builder: InteractionMessageModifyBuilder.() -> (Unit)): Message {
            val newMessage = InteractionMessageModifyBuilder().apply(builder).toMessageEditBuilder()

            return hook.editOriginal(newMessage.build()).submit().await()
        }

        override suspend fun deleteMessage() {
            hook.deleteOriginal()
        }
    }
}