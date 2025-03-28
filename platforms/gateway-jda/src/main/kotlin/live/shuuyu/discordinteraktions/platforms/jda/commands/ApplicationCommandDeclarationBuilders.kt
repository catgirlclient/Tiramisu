package live.shuuyu.discordinteraktions.platforms.jda.commands

import live.shuuyu.discordinteraktions.common.annotations.InteraKTionsDsl
import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.InteractionContextType
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions

public fun slashCommand(
    name: String,
    description: String,
    executor: SlashCommandExecutor,
    builder: SlashCommandDeclarationBuilder.() -> (Unit) = {}
): SlashCommandDeclarationBuilder = SlashCommandDeclarationBuilder(name, description, executor).apply(builder)

@InteraKTionsDsl
public class SlashCommandDeclarationBuilder(
    public val name: String,
    public val description: String,
    public val executor: SlashCommandExecutor
) {
    public var nameLocalization: Map<DiscordLocale, String>? = null
    public var descriptionLocalization: Map<DiscordLocale, String>? = null
    public var defaultMemberPermissions: DefaultMemberPermissions? = null
    public var subcommands: List<SlashCommandDeclarationBuilder> = mutableListOf()
    public var subcommandGroups: List<SlashCommandGroupDeclarationBuilder> = mutableListOf()
    public var contexts: List<InteractionContextType>? = null
    public var nsfw: Boolean? = null

    public fun subcommand(
        name: String,
        description: String,
        executor: SlashCommandExecutor,
        block: SlashCommandDeclarationBuilder.() -> (Unit)
    ) {
        subcommands += SlashCommandDeclarationBuilder(name, description, executor).apply(block)
    }

    public fun subcommandGroup(name: String, description: String, block: SlashCommandGroupDeclarationBuilder.() -> (Unit)) {
        subcommandGroups += SlashCommandGroupDeclarationBuilder(name, description).apply(block)
    }
}

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
        executor: SlashCommandExecutor,
        builder: SlashCommandDeclarationBuilder.() -> (Unit)) {
        subcommands += SlashCommandDeclarationBuilder(name, description, executor).apply(builder)
    }
}

public class UserCommandDeclarationBuilder(
    public val name: String,
    public val executor: UserCommandExecutor
) {

}