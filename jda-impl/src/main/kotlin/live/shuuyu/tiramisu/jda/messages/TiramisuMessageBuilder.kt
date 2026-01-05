package live.shuuyu.tiramisu.jda.messages

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.components.MessageTopLevelComponent
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.utils.FileUpload
import java.io.File
import java.io.InputStream
import java.nio.file.Files
import java.nio.file.Path
import kotlin.collections.addAll
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

public interface TiramisuMessageBuilder {
    public var content: String?

    /**
     * Embeds associated with the message. A message can have a maximum of 25 embeds.
     *
     * @since 1.0.0
     */
    public var embeds: MutableCollection<EmbedBuilder>?

    public var allowedMentions: MutableCollection<Message.MentionType>?

    public var components: MutableCollection<MessageTopLevelComponent>?

    public var files: MutableCollection<FileUpload>?

    public var isSuppressed: Boolean

    public fun addFile(name: String, content: InputStream) {
        val files = this.files ?: mutableListOf()
        files += FileUpload.fromData(content, name)
        this.files = files
    }

    public suspend fun addFile(path: Path): Unit = withContext(Dispatchers.IO) {
        addFile(path.fileName.toString(), Files.newInputStream(path))
    }

    public suspend fun addFile(file: File): Unit = withContext(Dispatchers.IO) {
        addFile(file.getName(), file.inputStream())
    }

    /**
     * Inserts multiple files into the given collection
     */
    public suspend fun addFiles(files: Collection<FileUpload>) {
        this.files?.addAll(files)
    }
}

/**
 * Creates an embed using [TiramisuEmbedBuilder], allowing for the usage of Kotlin DSL.
 *
 * @since 1.0.0
 * @author shuuyu
 */
@OptIn(ExperimentalContracts::class)
public inline fun TiramisuMessageBuilder.embed(builder: TiramisuEmbedBuilder.() -> Unit) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    embeds = (embeds ?: mutableListOf()).also {
        it.add(TiramisuEmbedBuilder().apply(builder))
    }
}

public fun TiramisuMessageBuilder.allowedMentions(vararg allowedMentions: Message.MentionType) {
    this.allowedMentions = (this.allowedMentions ?: mutableListOf()).also {
        it.addAll(allowedMentions)
    }
}

@OptIn(ExperimentalContracts::class)
public inline fun TiramisuMessageBuilder.actionRow(builder: TiramisuActionRowBuilder.() -> Unit) {
    contract {
        callsInPlace(builder, InvocationKind.EXACTLY_ONCE)
    }

    components = (components ?: mutableListOf()).also {
        it.add(TiramisuActionRowBuilder().apply(builder).build())
    }
}