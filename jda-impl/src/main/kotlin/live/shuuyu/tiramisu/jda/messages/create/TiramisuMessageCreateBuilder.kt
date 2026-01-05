package live.shuuyu.tiramisu.jda.messages.create

import live.shuuyu.tiramisu.common.annotations.TiramisuDsl
import live.shuuyu.tiramisu.jda.messages.TiramisuMessageBuilder
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder

/**
 * The base builder for creating a new message with Tiramisu.
 *
 * @since 1.0.0
 */
@TiramisuDsl
public interface TiramisuMessageCreateBuilder: TiramisuMessageBuilder {
    /**
     * Whether this message should be played as a text-to-speech message.
     *
     * @since 1.0.0
     */
    public var tts: Boolean

    public fun toMessageCreateBuilder(): MessageCreateBuilder
}