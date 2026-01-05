package live.shuuyu.tiramisu.jda

import live.shuuyu.tiramisu.common.request.InteractionRequestState
import live.shuuyu.tiramisu.jda.messages.EditableMessage
import live.shuuyu.tiramisu.jda.messages.create.InteractionMessageCreateBuilder
import live.shuuyu.tiramisu.jda.request.RequestBridge
import net.dv8tion.jda.api.requests.restaction.interactions.ReplyCallbackAction

/**
 * The barebones interaction context contains all the necessary channel interactions such as sending messages or modals.
 *
 * @since 1.0.0
 */
public open class BarebonesInteractionContext internal constructor (
    public val bridge: RequestBridge
) {
    public val isDeferred: Boolean
        get() = bridge.state.value != InteractionRequestState.NOT_REPLIED_YET
    public var wasInitiallyEphemerallyDeferred: Boolean = false

    /**
     * Defers the application command's request with a public message.
     *
     * @since 1.0.0
     */
    public suspend fun deferChannelMessage(): ReplyCallbackAction {
        if (isDeferred) {
            error("Trying to defer something that has already been deferred!")
        }

        wasInitiallyEphemerallyDeferred = false
        return bridge.manager.deferChannelMessage(false)
    }

    /**
     * Defers the application command's request with an ephemeral/private message.
     *
     * @since 1.0.0
     */
    public suspend fun deferChannelMessageEphemerally(): ReplyCallbackAction {
        if (isDeferred) {
            error("Trying to defer something that has already been deferred!")
        }

        wasInitiallyEphemerallyDeferred = true
        return bridge.manager.deferChannelMessage(true)
    }

    /**
     * Sends a public message, allowing for everyone in the guild to see it.
     *
     * By default, if the message contains files, the message will be automatically deferred.
     *
     * @return [EditableMessage] An instance of which messages can be edited.
     * @throws IllegalStateException If the message was deferred ephemerally, but you're trying to send a public message.
     *
     * @since 1.0.0
     * @see [InteractionMessageCreateBuilder]
     * @see [EditableMessage]
     */
    public suspend fun sendPublicMessage(message: InteractionMessageCreateBuilder): EditableMessage {
        if (bridge.state.value == InteractionRequestState.DEFERRED_CHANNEL_MESSAGE && wasInitiallyEphemerallyDeferred) {
            error("Trying to send a public message but the message was ephemerally deferred! Change the \\\"deferMessage(...)\\\" call to be public")
        }

        // Wait for the files to be uploaded, so we need to defer the message.
        if (message.files?.isNotEmpty() == true && !isDeferred) {
            deferChannelMessage()
        }

        return bridge.manager.sendMessage(message)
    }

    /**
     * Sends a public message, allowing for everyone in the guild to see it.
     *
     * By default, if the message contains files, the message will be automatically deferred.
     *
     * @return [EditableMessage] An instance of which messages can be edited.
     * @throws IllegalStateException If the message was deferred ephemerally, but you're trying to send a public message.
     *
     * @since 1.0.0
     * @see [InteractionMessageCreateBuilder]
     * @see [EditableMessage]
     */
    public suspend fun sendMessage(builder: InteractionMessageCreateBuilder.() -> (Unit)): EditableMessage =
        sendPublicMessage(InteractionMessageCreateBuilder(false).apply(builder))

    /**
     * Sends an ephemeral message, allowing only the executor/sender to see it.
     *
     * By default, if the message contains files, the message will be automatically deferred.
     *
     * @return [EditableMessage] An instance of which messages like this one can be edited.
     * @throws IllegalStateException If the message was deferred publicly, but you're trying to send an ephemeral message.
     *
     * @since 1.0.0
     * @see [InteractionMessageCreateBuilder]
     * @see [EditableMessage]
     */
    public suspend fun sendEphemeralMessage(message: InteractionMessageCreateBuilder): EditableMessage {
        if (bridge.state.value == InteractionRequestState.DEFERRED_CHANNEL_MESSAGE && wasInitiallyEphemerallyDeferred) {
            error("Trying to send an ephemeral message but the message was publicly deferred! Change the \\\"deferMessage(...)\\\" call to be ephemeral!")
        }

        if (message.files?.isNotEmpty() == true && !isDeferred) {
            deferChannelMessageEphemerally()
        }

        return bridge.manager.sendMessage(message)
    }

    /**
     * Sends an ephemeral message, allowing only the executor/sender to see it.
     *
     * By default, if the message contains files, the message will be automatically deferred.
     *
     * @return [EditableMessage] An instance of which messages like this one can be edited.
     * @throws IllegalStateException If the message was deferred publicly, but you're trying to send an ephemeral message.
     *
     * @since 1.0.0
     * @see [InteractionMessageCreateBuilder]
     * @see [EditableMessage]
     */
    public suspend fun sendEphemeralMessage(builder: InteractionMessageCreateBuilder.() -> (Unit)): EditableMessage =
        sendEphemeralMessage(InteractionMessageCreateBuilder(true).apply(builder))
}