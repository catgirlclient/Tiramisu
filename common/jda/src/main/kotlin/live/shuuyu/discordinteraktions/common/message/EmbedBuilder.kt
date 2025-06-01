package live.shuuyu.discordinteraktions.common.message

import kotlinx.datetime.Instant
import kotlinx.datetime.toJavaInstant
import live.shuuyu.discordinteraktions.common.shared.annotations.InteraKTionsDsl
import live.shuuyu.discordinteraktions.common.shared.annotations.InteraKTionsInternal
import live.shuuyu.discordinteraktions.common.shared.utils.Color
import net.dv8tion.jda.api.EmbedBuilder
import net.dv8tion.jda.api.entities.MessageEmbed
import net.dv8tion.jda.api.EmbedBuilder as JDAEmbedBuilder

/**
 * Discord InteraKTions embed builder, which relies on Kotlin's DSL. Can be transpiled into JDA's [JDAEmbedBuilder] if
 * required.
 *
 * @since 1.0.0
 * @author shuuyu
 */
@InteraKTionsDsl
public class EmbedBuilder: JDAEmbedBuilder() {
    public companion object {
        public const val ZERO_WIDTH_SPACE: String = "\u200B"
    }

    /**
     * The author of the embed.
     *
     * @see [Author]
     * @since 1.0.0
     * @author shuuyu
     */
    public var author: Author? = null

    /**
     * The color of the embed.
     *
     * @see [Color]
     * @since 1.0.0
     * @author shuuyu
     */
    public var color: Color? = null

    /**
     * The description of the embed.
     *
     * @throws IllegalArgumentException If the description is longer than 4096 characters.
     * @since 1.0.0
     * @author shuuyu
     */
    public var description: String? = null

    /**
     * The fields associated with the embed. By default, no fields exist within the embed.
     *
     * @see Field
     * @since 1.0.0
     * @author shuuyu
     */
    public var fields: MutableSet<Field> = mutableSetOf()

    /**
     * The footer associated with the embed. By default, no fields exist within the embed.
     *
     * @see [Author]
     * @since 1.0.0
     * @author shuuyu
     */
    public var footer: Footer? = null

    /**
     * The image of the embed.
     *
     * @throws IllegalArgumentException If the character limit for url is longer than 2000 characters.
     * @throws IllegalArgumentException If the image URL is invalid.
     * @since 1.0.0
     * @author shuuyu
     */
    public var image: String? = null

    /**
     * The thumbnail associated with the embed.
     *
     * @see [Thumbnail]
     * @since 1.0.0
     * @author shuuyu
     */
    public var thumbnail: Thumbnail? = null

    /**
     * The timestamp of when this embed was sent.
     *
     * @see Instant
     * @since 1.0.0
     * @author shuuyu
     */
    public var timestamp: Instant? = null

    /**
     * The title of the embed.
     *
     * @throws IllegalStateException If the title is longer than 256 characters.
     * @since 1.0.0
     * @author shuuyu
     */
    public var title: String? = null

    /**
     * The URL associated with the [title] of the embed.
     *
     * @since 1.0.0
     * @author shuuyu
     */
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
        Footer().apply(builder)
    }

    public fun thumbnail(builder: Thumbnail.() -> (Unit)) {
        Thumbnail().apply(builder)
    }

    public inner class Author {
        /**
         * The name of the author.
         *
         * @throws IllegalArgumentException If the length of the name is longer than 256 characters.
         * @throws IllegalArgumentException If [url] is not null, and the given value for name is null.
         * @since 1.0.0
         * @author shuuyu
         */
        public var name: String? = null

        /**
         * The url associated with the author.
         *
         * @throws IllegalArgumentException If the [name] is null, but [url] is not null.
         * @since 1.0.0
         * @author shuuyu
         */
        public var url: String? = null

        /**
         * The url of the icon associated with the author.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public var iconUrl: String? = null

        public var proxyUrl: String? = null

        public fun build(): MessageEmbed.AuthorInfo {
            return MessageEmbed.AuthorInfo(
                name,
                url,
                iconUrl,
                proxyUrl
            )
        }
    }

    public inner class Field {
        /**
         * The name or title of the field, being empty/null by default.
         *
         * @throws IllegalArgumentException If the name is longer than 256 characters.
         * @since 1.0.0
         * @author shuuyu
         */
        public var name: String = ZERO_WIDTH_SPACE

        /**
         * The description or the content of the field, being empty/bull by default.
         *
         * @throws IllegalArgumentException If the value of the field is longer than 200 characters.
         * @since 1.0.0
         * @author shuuyu
         */
        public var value: String = ZERO_WIDTH_SPACE

        /**
         * Whether the message will stack on top of each other and be compacted.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public var inline: Boolean = false

        @InteraKTionsInternal
        public fun build(): MessageEmbed.Field {
            return MessageEmbed.Field(
                name,
                value,
                inline
            )
        }
    }

    public inner class Footer {
        /**
         * The text in the footer.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public lateinit var text: String

        /**
         * The link that's applied to the text of the footer.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public var url: String? = null

        /**
         * The icon of the footer.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public var iconUrl: String? = null
    }

    public inner class Thumbnail {
        /**
         * The image url of the thumbnail.
         *
         * @since 1.0.0
         * @author shuuyu
         */
        public lateinit var url: String
    }

    @OptIn(InteraKTionsInternal::class)
    override fun build(): MessageEmbed {
        return EmbedBuilder().apply {
            setAuthor(author?.name, author?.url, author?.iconUrl)
            setDescription(description)
            this@EmbedBuilder.fields.map { addField(it.build()) }
            setFooter(footer?.text, footer?.iconUrl)
            setThumbnail(thumbnail?.url)
            setTitle(title, url)
            setTimestamp(timestamp?.toJavaInstant())
            setImage(image)
        }.build()
    }
}