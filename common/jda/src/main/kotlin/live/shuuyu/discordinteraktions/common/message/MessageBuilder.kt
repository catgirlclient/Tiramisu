package live.shuuyu.discordinteraktions.common.message

import net.dv8tion.jda.api.utils.FileUpload
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// Unfortunately for me JDA and Kord share no parts commonality, so I basically have to reimplement a separate version of this.
public interface MessageBuilder {
    /**
     * The content of the message being supplied, with a maximum of 200 characters.
     *
     * @since 1.0.0
     */
    public var content: String?

    /**
     * Embeds associated with the message. You can have a maximum of 10 embeds in one message.
     *
     * @since 1.0.0
     */
    public var embeds: MutableList<net.dv8tion.jda.api.EmbedBuilder>?

    /**
     * The attached files correlating to the message itself.
     *
     * @since 0.0.1
     */
    public var attachments: MutableList<FileUpload>

    /**
     * Embeds will be suppressed/excluded when serializing the message.
     *
     * @since 1.0.0
     */
    public var isSuppressed: Boolean?

    public fun addFile(files: List<FileUpload>): List<FileUpload> {
        attachments.addAll(files)
        return files
    }
}

@OptIn(ExperimentalContracts::class)
public inline fun MessageBuilder.embed(builder: EmbedBuilder.() -> (Unit)) {
    contract { callsInPlace(builder, InvocationKind.EXACTLY_ONCE) }
    val embed = EmbedBuilder().apply(builder)
    embeds?.add(embed) ?: run { embeds = mutableListOf(embed) }
}