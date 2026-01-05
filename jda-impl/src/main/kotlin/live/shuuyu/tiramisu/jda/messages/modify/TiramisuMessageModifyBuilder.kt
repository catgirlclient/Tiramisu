package live.shuuyu.tiramisu.jda.messages.modify

import live.shuuyu.tiramisu.common.annotations.TiramisuDsl
import live.shuuyu.tiramisu.jda.messages.TiramisuMessageBuilder
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder

@TiramisuDsl
public sealed interface TiramisuMessageModifyBuilder: TiramisuMessageBuilder {
    public var attachments: MutableCollection<Message.Attachment>?

    public fun toMessageEditBuilder(): MessageEditBuilder
}