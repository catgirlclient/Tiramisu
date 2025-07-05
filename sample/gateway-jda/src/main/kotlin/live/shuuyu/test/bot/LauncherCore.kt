package live.shuuyu.test.bot

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder

public class LauncherCore() {
    // Starts an instance of JDA that disables anything related to caching. If you want to enable JDA's cache,
    // This will give you more control over your project, but will require more lines of code to upkeep.
    public val jda: JDA = JDABuilder.createLight(System.getenv("TOKEN"))
        .build()
}