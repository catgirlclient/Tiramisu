package live.shuuyu.discordinteraktions.common.commands

/**
 * The over head class, so we can declare all the command declarations at conversion.
 * Ideally, this should NOT be public, since this only concerns application commands
 * related to the framework.
 *
 * @since 1.0.0
 */
public sealed interface ApplicationCommandDeclarationWrapper

/**
 * Declares the slash command, making it available with the given parameters.
 *
 * @see SlashCommandDeclarationBuilder
 * @since 1.0.0
 */
public interface SlashCommandDeclarationWrapper: ApplicationCommandDeclarationWrapper {
    public fun declaration(): SlashCommandDeclarationBuilder
}

/**
 * Declares the message command, making it available with the given parameters.
 *
 * @see UserCommandDeclarationBuilder
 * @since 1.0.0
 */
public interface UserCommandDeclarationWrapper: ApplicationCommandDeclarationWrapper {
    public fun declaration(): UserCommandDeclarationBuilder
}

/**
 * Declares the message command, making it available with the given parameters.
 *
 * @see MessageCommandDeclarationWrapper
 * @since 1.0.0
 */
public interface MessageCommandDeclarationWrapper: ApplicationCommandDeclarationWrapper {
    public fun declaration(): MessageCommandDeclarationBuilder
}