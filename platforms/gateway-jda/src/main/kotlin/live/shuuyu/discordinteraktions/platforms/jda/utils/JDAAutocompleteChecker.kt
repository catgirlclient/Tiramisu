package live.shuuyu.discordinteraktions.platforms.jda.utils

import io.github.oshai.kotlinlogging.KotlinLogging
import live.shuuyu.discordinteraktions.common.requests.managers.RequestManager

public class JDAAutocompleteChecker() {
    public companion object {
        private val logger = KotlinLogging.logger {  }
    }

    public fun checkAndExecute(requestManager: RequestManager) {
        logger.debug { requestManager.bridge.state.value.name }
    }
}