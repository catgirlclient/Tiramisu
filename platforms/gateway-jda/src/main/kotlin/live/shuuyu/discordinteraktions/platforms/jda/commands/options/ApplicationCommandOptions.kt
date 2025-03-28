package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import live.shuuyu.discordinteraktions.common.commands.options.DiscordCommandOption


public open class ApplicationCommandOptions() {
    public companion object {
        public val NO_OPTIONS: ApplicationCommandOptions = object: ApplicationCommandOptions() {}
    }

    public val registeredOptions: MutableList<DiscordCommandOption<*>> = mutableListOf()
}