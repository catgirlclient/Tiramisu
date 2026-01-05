package live.shuuyu.tiramisu.jda.messages.modify

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.components.MessageTopLevelComponent
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.utils.FileUpload
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder

public class InteractionMessageModifyBuilder: TiramisuMessageModifyBuilder {
    override var content: String? = null
    override var embeds: MutableCollection<EmbedBuilder>? = mutableListOf()
    override var allowedMentions: MutableCollection<Message.MentionType>? = mutableListOf()
    override var components: MutableCollection<MessageTopLevelComponent>? = mutableListOf()
    override var files: MutableCollection<FileUpload>? = mutableListOf()
    override var attachments: MutableCollection<Message.Attachment>? = mutableListOf()
    override var isSuppressed: Boolean = false

    override fun toMessageEditBuilder(): MessageEditBuilder {
        return MessageEditBuilder().apply {
            setContent(content)
            setEmbeds(embeds)
            setAllowedMentions(allowedMentions)
            setComponents(components)
            setFiles(files)
            setAttachments(attachments)
            isSuppressEmbeds = isSuppressed
        }
    }
}