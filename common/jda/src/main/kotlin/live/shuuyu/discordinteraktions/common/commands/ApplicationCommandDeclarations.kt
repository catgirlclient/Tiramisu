package live.shuuyu.discordinteraktions.common.commands

import net.dv8tion.jda.api.interactions.DiscordLocale
import net.dv8tion.jda.api.interactions.InteractionContextType
import net.dv8tion.jda.api.interactions.commands.DefaultMemberPermissions

public sealed class ApplicationCommandDeclaration {
    public abstract val name: String
    public abstract val nameLocalizations: Map<DiscordLocale, String>?
}

public abstract class SlashCommandDeclaration : ApplicationCommandDeclaration() {
    public abstract val description: String
    public abstract val descriptionLocalizations: Map<DiscordLocale, String>?
    public abstract val executor: SlashCommandExecutor
    public abstract val defaultMemberPermissions: DefaultMemberPermissions?
    public abstract val subcommands: List<SlashCommandDeclaration>
    public abstract val subcommandGroups: List<SlashCommandGroupDeclaration>
    public abstract val contexts: List<InteractionContextType>?
    public abstract val nsfw: Boolean?
}

public abstract class SlashCommandGroupDeclaration : ApplicationCommandDeclaration() {
    public abstract val description: String
    public abstract val descriptionLocalizations: Map<DiscordLocale, String>?
    public abstract val subcommands: List<SlashCommandDeclaration>
    public abstract val nsfw: Boolean?
}

public abstract class UserCommandDeclaration : ApplicationCommandDeclaration() {
    public abstract val defaultMemberPermissions: DefaultMemberPermissions?
    public abstract val executor: UserCommandExecutor // User/Message commands always requires an executor, that's why it is not nullable!
    public abstract val contexts: List<InteractionContextType>?
    public abstract val nsfw: Boolean?
}

public abstract class MessageCommandDeclaration : ApplicationCommandDeclaration() {
    public abstract val defaultMemberPermissions: DefaultMemberPermissions?
    public abstract val executor: MessageCommandExecutor // User/Message commands always requires an executor, that's why it is not nullable!
    public abstract val contexts: List<InteractionContextType>?
    public abstract val nsfw: Boolean?
}

// ===[ DEFAULT IMPLEMENTATIONS ]===
public class InteraKTionsSlashCommandDeclaration(
    override val name: String,
    override val nameLocalizations: Map<DiscordLocale, String>? = null,
    override val description: String,
    override val descriptionLocalizations: Map<DiscordLocale, String>? = null,
    override val executor: SlashCommandExecutor,
    override val defaultMemberPermissions: DefaultMemberPermissions?,
    override val contexts: List<InteractionContextType>?,
    override val subcommands: List<SlashCommandDeclaration>,
    override val subcommandGroups: List<SlashCommandGroupDeclaration>,
    override val nsfw: Boolean?
) : SlashCommandDeclaration()

public class InteraKTionsSlashCommandGroupDeclaration(
    override val name: String,
    override val nameLocalizations: Map<DiscordLocale, String>? = null,
    override val description: String,
    override val descriptionLocalizations: Map<DiscordLocale, String>? = null,
    override val subcommands: List<SlashCommandDeclaration>,
    override val nsfw: Boolean?
) : SlashCommandGroupDeclaration()

public class InteraKTionsUserCommandDeclaration(
    override val name: String,
    override val nameLocalizations: Map<DiscordLocale, String>? = null,
    override val executor: UserCommandExecutor,
    override val defaultMemberPermissions: DefaultMemberPermissions?,
    override val contexts: List<InteractionContextType>?,
    override val nsfw: Boolean?
) : UserCommandDeclaration()

public class InteraKTionsMessageCommandDeclaration(
    override val name: String,
    override val nameLocalizations: Map<DiscordLocale, String>? = null,
    override val executor: MessageCommandExecutor,
    override val defaultMemberPermissions: DefaultMemberPermissions?,
    override val contexts: List<InteractionContextType>?,
    override val nsfw: Boolean?
) : MessageCommandDeclaration()