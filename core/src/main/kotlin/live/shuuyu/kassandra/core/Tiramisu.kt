package live.shuuyu.kassandra.core

import com.datastax.oss.driver.api.core.CqlSession
import live.shuuyu.kassandra.core.utils.TransactionBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

public class Tiramisu(

) {
    public companion object {
        public val logger: Logger = LoggerFactory.getLogger("Tiramisu")

        /**
         * Initialize and connects to the given NoSQL database.
         *
         * @since 0.0.1
         * @author yujin
         */
        public fun initialize(): Tiramisu {
            CqlSession.builder().build().use { session ->

            }

            return Tiramisu()
        }
    }


    public fun transaction(builder: TransactionBuilder.() -> (Unit)) {
        TransactionBuilder().apply(builder).builder()
    }

    public fun suspendableTransaction(builder: suspend (TransactionBuilder) -> Unit) {

    }

    public fun select(clazz: KClass<*>) {

    }
}