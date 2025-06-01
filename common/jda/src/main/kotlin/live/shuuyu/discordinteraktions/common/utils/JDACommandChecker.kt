package live.shuuyu.discordinteraktions.common.utils

import io.github.oshai.kotlinlogging.KotlinLogging
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

public class JDACommandChecker() {
    public companion object: CoroutineScope {
        private val logger = KotlinLogging.logger {   }
        override val coroutineContext: CoroutineContext = Dispatchers.IO + SupervisorJob() + CoroutineName(this::class.java.simpleName)
        private val scope = CoroutineScope(coroutineContext)
    }

    public fun checkAndExecute() {

    }
}