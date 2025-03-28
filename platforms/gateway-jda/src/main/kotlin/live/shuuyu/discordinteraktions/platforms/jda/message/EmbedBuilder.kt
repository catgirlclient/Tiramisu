package live.shuuyu.discordinteraktions.platforms.jda.message

import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import net.dv8tion.jda.api.EmbedBuilder
import java.awt.Color

public class EmbedBuilder {
    /**
     * The title of your embed. Limited to the length of [Limits.title].
     *
     * @since 1.0.0
     */
    public var title: String? = null

    /**
     * The description of your embed. Limited to the length of [Limits.description]
     *
     * @since 1.0.0
     */
    public var description: String? = null

    /**
     * The url of the embed's [title].
     *
     * @since 1.0.0
     */
    public var url: String? = null

    /**
     * The timestamp of when this embed was sent. This uses Kotlin DateTime's [Instant].
     *
     * @since 0.0.1
     */
    public var timestamp: Instant? = null

    /**
     * The color of the embed.
     *
     * @see Color
     *
     * @since 1.0.0
     */
    public var color: Color? = null

    /**
     * The image associated with the embed.
     *
     * @since 1.0.0
     */
    public var image: String? = null

    /**
     * The footer associated with the embed.
     *
     * @since 1.0.0
     */
    public var footer: Footer? = null

    public var thumbnail: Thumbnail? = null

    public var fields: MutableList<Field> = mutableListOf()

    public inline fun footer(builder: Footer.() -> (Unit)) {
        footer = (footer ?: Footer()).apply(builder)
    }

    public inline fun thumbnail(builder: Thumbnail.() -> (Unit)) {
        thumbnail = (thumbnail ?: Thumbnail()).apply(builder)
    }

    public inline fun field(builder: Field.() -> (Unit)) {
        fields.add(Field().apply(builder))
    }

    public fun field(name: String, value: String, inline: Boolean? = false) {
        val field = Field()
        field.name = name
        field.value = value
        field.inline = inline

        fields.add(field)
    }

    /**
     * Converts Discord InteraKTions embeds to JDA embeds, which guarantees compatibility.
     */
    public fun toJDAEmbedBuilder(): EmbedBuilder {
        return EmbedBuilder().apply {
            setTitle(title)
            setDescription(description)
            setUrl(url)
            setColor(color)
            setTimestamp(timestamp?.toJavaInstant())
            setThumbnail(thumbnail?.url)
            setFooter(footer?.text, footer?.icon)
        }
    }

    public class Field {
        public var name: String? = null
        public var value: String? = null
        public var inline: Boolean? = null
    }

    public class Footer {
        public var text: String? = null
        public var icon: String? = null
    }

    public class Thumbnail {
        public var url: String? = null
    }

    public object Limits {
        public const val title: Int = 256
        public const val description: Int = 2048
    }
}