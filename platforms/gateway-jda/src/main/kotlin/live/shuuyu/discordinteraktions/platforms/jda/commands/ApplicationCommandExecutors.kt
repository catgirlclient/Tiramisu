package live.shuuyu.discordinteraktions.platforms.jda.commands

import net.dv8tion.jda.api.entities.Member
import net.dv8tion.jda.api.entities.Message
import net.dv8tion.jda.api.entities.User

public sealed class ApplicationCommandExecutors {
    public open fun signature(): Any = this::class
}

/**
 * Creates a slash command, allowing for users to execute commands via the chat with a ``/`` as its prefix.
 *
 * @see SlashCommandDeclarationBuilder
 *
 * @since 1.0.0
 */
public abstract class SlashCommandExecutor {
    public abstract suspend fun execute(context: ApplicationCommandContext)
}

/**
 * Creates a user command, allowing for anyone interacting with your profile to execute the code provided in execute.
 *
 * **Note: The [Member] clause is nullable because if you're executing a command where a user isn't in the guild, it
 * results in the command returning a null member.**
 * ## Example
 *
 * ```kotlin
 * class MyUserCommand: UserCommandExecutor(), UserCommandDeclarationWrapper {
 *      // Declares your command. Make sure that you properly upsert the command in the command manager!
 *      override fun declaration() = userCommand("myuser", this)
 *
 *      // Anything inside of this block will execute when a user sends a request to your bot.
 *      override suspend fun execute(context: ApplicationCommandContext, targetUser: User, targetMember: Member?) {
 *          context.sendMessage(content = targetUser.name) // Sends the target user's name
 *      }
 * }
 * ```
 *
 * @see UserCommandDeclarationBuilder
 *
 * @since 1.0.0
 */
public abstract class UserCommandExecutor {
    public abstract suspend fun execute(context: ApplicationCommandContext, targetUser: User, targetMember: Member?)
}

/**
 * Creates a message command, allowing for anyone with permissions to interact with any message and execute the code
 * provided in execute.
 *
 * ```kotlin
 * class MyMessageCommand: MessageCommandExecutor(), MessageCommandDeclarationWrapper {
 *      override fun declaration() = messageCommand("name", this@executor)
 *
 *      override suspend fun execute(context: ApplicationCommandContext, targetMessage: Message) {
 *          context.sendMessage(targetMessage.content)
 *      }
 * }
 * ```
 *
 * @since 1.0.0
 */
public abstract class MessageCommandExecutor {
    public abstract suspend fun execute(context: ApplicationCommandContext, targetMessage: Message)
}