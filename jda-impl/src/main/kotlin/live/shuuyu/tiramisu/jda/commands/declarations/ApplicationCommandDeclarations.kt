package live.shuuyu.tiramisu.jda.commands.declarations

import net.dv8tion.jda.api.interactions.DiscordLocale

public sealed class ApplicationCommandDeclaration {
    public abstract val name: String
    public abstract val nameLocalization: Map<DiscordLocale, String>
}