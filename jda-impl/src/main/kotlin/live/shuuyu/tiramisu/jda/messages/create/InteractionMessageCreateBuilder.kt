package live.shuuyu.tiramisu.jda.messages.create

import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.components.MessageTopLevelComponent
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.utils.FileUpload
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder

public class InteractionMessageCreateBuilder(public val ephemeral: Boolean): TiramisuMessageCreateBuilder {
    override var content: String? = null
    override var embeds: MutableCollection<EmbedBuilder>? = mutableListOf()
    override var allowedMentions: MutableCollection<Message.MentionType>? = mutableListOf()
    override var components: MutableCollection<MessageTopLevelComponent>? = mutableListOf()
    override var files: MutableCollection<FileUpload>? = mutableListOf()
    override var tts: Boolean = false
    override var isSuppressed: Boolean = false

    override fun toMessageCreateBuilder(): MessageCreateBuilder = MessageCreateBuilder().run {
        setContent(content)
        setEmbeds(embeds)
        setAllowedMentions(allowedMentions)
        addComponents(components)
        setComponents(components)
        setFiles(files)
        setTTS(tts)
        setSuppressEmbeds(isSuppressed)
    }
}