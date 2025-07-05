    package live.shuuyu.discordinteraktions.common.commands

import live.shuuyu.discordinteraktions.common.shared.annotations.InteraKTionsDsl
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.InteractionContextType
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions

/**
 * Creates a slash command.
 *
 * @param name The name of the slash command.
 * @param description The description of the slash command.
 *
 * @see SlashCommandExecutor
 * @since 1.0.0
 */
public fun slashCommand(
    name: String,
    description: String,
    builder: SlashCommandDeclarationBuilder.() -> (Unit) = {}
): SlashCommandDeclarationBuilder = SlashCommandDeclarationBuilder(name, description).apply(builder)

@InteraKTionsDsl
public class SlashCommandDeclarationBuilder(
    public val name: String,
    public val description: String,
) {
    public var nameLocalization: Map<DiscordLocale, String>? = null
    public var descriptionLocalization: Map<DiscordLocale, String>? = null
    public var defaultMemberPermissions: DefaultMemberPermissions? = null
    public var executor: SlashCommandExecutor? = null
    public var subcommands: List<SlashCommandDeclarationBuilder> = mutableListOf()
    public var subcommandGroups: List<SlashCommandGroupDeclarationBuilder> = mutableListOf()
    public var contexts: List<InteractionContextType>? = null
    public var nsfw: Boolean? = null

    public fun subcommand(
        name: String,
        description: String,
        block: SlashCommandDeclarationBuilder.() -> (Unit)
    ) {
        subcommands += SlashCommandDeclarationBuilder(name, description).apply(block)
    }

    public fun subcommandGroup(name: String, description: String, block: SlashCommandGroupDeclarationBuilder.() -> (Unit)) {
        subcommandGroups += SlashCommandGroupDeclarationBuilder(name, description).apply(block)
    }

    public fun build(): SlashCommandDeclaration = InteraKTionsSlashCommandDeclaration(
        name,
        nameLocalization,
        description,
        descriptionLocalization,
        executor,
        defaultMemberPermissions,
        contexts,
        subcommands.map { it.build() },
        subcommandGroups.map { it.build() },
        nsfw
    )
}

@InteraKTionsDsl
public class SlashCommandGroupDeclarationBuilder(
    public val name: String,
    public val description: String
) {
    public var nameLocalization: Map<DiscordLocale, String>? = null
    public var descriptionLocalization: Map<DiscordLocale, String>? = null
    public var subcommands: List<SlashCommandDeclarationBuilder> = mutableListOf()
    public var nsfw: Boolean? = null

    public fun subcommand(
        name: String,
        description: String,
        builder: SlashCommandDeclarationBuilder.() -> (Unit)
    ) {
        subcommands += SlashCommandDeclarationBuilder(name, description).apply(builder)
    }

    public fun build(): SlashCommandGroupDeclaration = InteraKTionsSlashCommandGroupDeclaration (
        name,
        nameLocalization,
        description,
        descriptionLocalization,
        subcommands.map { it.build()},
        nsfw
    )
}

public fun userCommand(
    name: String,
    executor: UserCommandExecutor,
    builder: UserCommandDeclarationBuilder.() -> (Unit) = {}
): UserCommandDeclarationBuilder = UserCommandDeclarationBuilder(name, executor).apply(builder)

public class UserCommandDeclarationBuilder(
    public val name: String,
    public val executor: UserCommandExecutor
) {
    public var nameLocalizations: Map<DiscordLocale, String>? = null
    public var defaultMemberPermissions: DefaultMemberPermissions? = null
    public var contexts: List<InteractionContextType>? = mutableListOf()
    public var nsfw: Boolean? = null

    public fun build(): UserCommandDeclaration = InteraKTionsUserCommandDeclaration(
        name,
        nameLocalizations,
        executor,
        defaultMemberPermissions,
        contexts,
        nsfw
    )
}

public fun messageCommand(
    name: String,
    executor: MessageCommandExecutor,
    builder: MessageCommandDeclarationBuilder.() -> (Unit) = {}
): MessageCommandDeclarationBuilder = MessageCommandDeclarationBuilder(name, executor).apply(builder)


public class MessageCommandDeclarationBuilder(
    public val name: String,
    public val executor: MessageCommandExecutor
) {
    public var nameLocalizations: Map<DiscordLocale, String>? = null
    public var defaultMemberPermissions: DefaultMemberPermissions? = null
    public var contexts: List<InteractionContextType>? = mutableListOf()
    public var nsfw: Boolean? = null

    public fun build(): MessageCommandDeclaration = InteraKTionsMessageCommandDeclaration(
        name,
        nameLocalizations,
        executor,
        defaultMemberPermissions,
        contexts,
        nsfw
    )
}
