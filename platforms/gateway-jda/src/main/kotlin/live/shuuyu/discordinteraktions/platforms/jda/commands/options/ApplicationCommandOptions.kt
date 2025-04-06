package live.shuuyu.discordinteraktions.platforms.jda.commands.options

import live.shuuyu.discordinteraktions.common.commands.options.OptionReference


public open class ApplicationCommandOptions() {
    public companion object {
        public val NO_OPTIONS: ApplicationCommandOptions = object: ApplicationCommandOptions() {}
    }

    public val registeredOptions: MutableList<InteraKTionsCommandOption<*>> = mutableListOf()
    public val references: MutableList<OptionReference<*>> = mutableListOf()

    /**
    public fun string(
        name: String,
        description: String,
    ): OptionReference<String> {

    }
    **/
}