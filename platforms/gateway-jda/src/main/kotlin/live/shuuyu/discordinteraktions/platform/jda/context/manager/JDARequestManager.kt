package live.shuuyu.discordinteraktions.platform.jda.context.manager

import dev.kord.common.entity.Choice
import dev.kord.rest.builder.interaction.ModalBuilder
import live.shuuyu.discordinteraktions.common.builder.message.create.InteractionOrFollowupMessageCreateBuilder
import live.shuuyu.discordinteraktions.common.builder.message.modify.InteractionOrFollowupMessageModifyBuilder
import live.shuuyu.discordinteraktions.common.entities.messages.EditableMessage
import live.shuuyu.discordinteraktions.common.requests.RequestBridge
import live.shuuyu.discordinteraktions.common.requests.managers.RequestManager
import net.dv8tion.jda.api.interactions.Interaction

public open class JDARequestManager(bridge: RequestBridge, private val interaction: Interaction) : RequestManager(bridge) {
    override suspend fun deferChannelMessage() {
        TODO("Not yet implemented")
    }

    override suspend fun deferChannelMessageEphemerally() {
        TODO("Not yet implemented")
    }

    override suspend fun sendPublicMessage(message: InteractionOrFollowupMessageCreateBuilder): EditableMessage {
        TODO("Not yet implemented")
    }

    override suspend fun sendEphemeralMessage(message: InteractionOrFollowupMessageCreateBuilder): EditableMessage {
        TODO("Not yet implemented")
    }

    override suspend fun deferUpdateMessage() {
        TODO("Not yet implemented")
    }

    override suspend fun updateMessage(message: InteractionOrFollowupMessageModifyBuilder): EditableMessage {
        TODO("Not yet implemented")
    }

    override suspend fun sendStringAutocomplete(list: List<Choice.StringChoice>) {
        TODO("Not yet implemented")
    }

    override suspend fun sendIntegerAutocomplete(list: List<Choice.IntegerChoice>) {
        TODO("Not yet implemented")
    }

    override suspend fun sendNumberAutocomplete(list: List<Choice.NumberChoice>) {
        TODO("Not yet implemented")
    }

    override suspend fun sendModal(title: String, customId: String, builder: ModalBuilder.() -> Unit) {
        TODO("Not yet implemented")
    }

}