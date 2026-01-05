package live.shuuyu.tiramisu.jda.messages.create

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.components.MessageTopLevelComponent
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.utils.FileUpload
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder

/**
 * An instance of the component V2 message builder. By default, al content, embeds, mentions, files, and tts
 * are no-op and will do nothing.
 *
 * @since 1.0.0
 */
public class ComponentV2MessageCreateBuilder(ephemeral: Boolean) : TiramisuMessageCreateBuilder {
    override var content: String? = null
    override var embeds: MutableCollection<EmbedBuilder>? = mutableListOf()
    override var allowedMentions: MutableCollection<Message.MentionType>? = mutableListOf()
    override var components: MutableCollection<MessageTopLevelComponent>? = mutableListOf()
    override var files: MutableCollection<FileUpload>? = mutableListOf()
    override var tts: Boolean = false
    override var isSuppressed: Boolean = false

    override fun toMessageCreateBuilder(): MessageCreateBuilder = MessageCreateBuilder().run {
        useComponentsV2()
        setComponents(components)
    }
}