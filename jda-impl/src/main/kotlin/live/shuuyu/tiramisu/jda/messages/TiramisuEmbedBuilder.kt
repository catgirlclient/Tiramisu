package live.shuuyu.tiramisu.jda.messages

import live.shuuyu.tiramisu.common.annotations.TiramisuDsl
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import java.awt.Color
import kotlin.time.ExperimentalTime
import kotlin.time.Instant
import kotlin.time.toJavaInstant

@TiramisuDsl
@OptIn(ExperimentalTime::class)
public open class TiramisuEmbedBuilder(): EmbedBuilder() {
    public companion object {
        public const val ZERO_WIDTH_SPACE: String = "\u200B"
    }

    public var author: Author? = null
    public var color: Color? = null
    public var description: String? = null
    public var fields: MutableSet<Field> = mutableSetOf()
    public var footer: Footer? = null
    public var image: String? = null
    public var thumbnail: Thumbnail? = null
    public var timestamp: Instant? = null
    public var title: String? = null
    public var url: String? = null

    public fun author(builder: Author.() -> (Unit)) {
        Author().apply(builder)
    }

    public fun field(builder: Field.() -> (Unit)) {
        fields.add(Field().apply(builder))
    }

    public fun field(name: String, value: String, inline: Boolean = false) {
        val field = Field()
        field.name = name
        field.value = value
        field.inline = inline
        fields.add(field)
    }

    public fun footer(builder: Footer.() -> (Unit)) {
        footer = Footer().apply(builder)
    }

    public fun thumbnail(builder: Thumbnail.() -> (Unit)) {
        thumbnail = Thumbnail().apply(builder)
    }

    public class Author {
        public var name: String? = null
        public var url: String? = null
        public var iconUrl: String? = null

        public var proxyUrl: String? = null

        public fun build(): MessageEmbed.AuthorInfo = MessageEmbed.AuthorInfo(name, url, iconUrl, proxyUrl)
    }

    public class Field {
        public var name: String = ZERO_WIDTH_SPACE
        public var value: String = ZERO_WIDTH_SPACE
        public var inline: Boolean = false

        public fun build(): MessageEmbed.Field = MessageEmbed.Field(name, value, inline)
    }

    public class Footer {
        public lateinit var text: String
        public var url: String? = null
        public var iconUrl: String? = null
    }

    public class Thumbnail {
        public var url: String? = null
    }

    override fun build(): MessageEmbed {
        return EmbedBuilder().apply {
            setAuthor(author?.name, author?.url, author?.iconUrl)
            setDescription(description)
            this@TiramisuEmbedBuilder.fields.map { addField(it.build()) }
            setFooter(footer?.text, footer?.iconUrl)
            setThumbnail(thumbnail?.url)
            setTitle(title, url)
            setTimestamp(timestamp?.toJavaInstant())
            setImage(image)
        }.build()
    }
}