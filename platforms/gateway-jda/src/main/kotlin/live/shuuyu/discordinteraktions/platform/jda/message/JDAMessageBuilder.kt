package live.shuuyu.discordinteraktions.platform.jda.message

import net.dv8tion.jda.api.EmbedBuilder

// Unfortunately for me JDA and Kord share no parts commonality, so I basically have to reimplement a separate version of this.
public interface JDAMessageBuilder {
    /**
     * The content of the message being supplied, with a maximum of 200 characters.
     *
     * @since 0.0.1
     */
    public var content: String?

    /**
     * Embeds associated with the message. You can have a maximum of 10 embeds in one message.
     *
     * @since 0.0.1
     */
    public var embeds: MutableList<EmbedBuilder>?
}