package live.shuuyu.tiramisu.core

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder.createTable
import live.shuuyu.tiramisu.core.dsl.DslHandler
import live.shuuyu.tiramisu.core.nosql.Table
import live.shuuyu.tiramisu.core.utils.TransactionBuilder
import live.shuuyu.tiramisu.core.utils.config.TiramisuConfig
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

public class Tiramisu: DslHandler(session) {
    public companion object {
        public val logger: Logger = LoggerFactory.getLogger("Tiramisu")
        private val session = CqlSession.builder().build()
        public var isInitialized: Boolean = false

        /**
         * Initialize and connects to the given NoSQL database.
         *
         * @since 0.0.1
         * @author yujin
         */
        public fun initialize(config: TiramisuConfig): Tiramisu {
            session.use { s ->
                isInitialized = true

            }

            return Tiramisu()
        }

        /**
         * Stops the connection to the given NoSQL database.
         *
         * @throws IllegalStateException If no pre-existing database exists.
         * @since 0.0.1
         * @author yujin
         */
        public fun close() {
            if (!session.isClosed)
                throw IllegalStateException("No such session is currently initialized!")

            isInitialized = false
            session.closeAsync()
        }
    }

    /**
     * Returns a set of tables that have been created in the database.
     *
     * @see [Table]
     * @since 0.0.1
     * @author yujin
     */
    public var registeredTables: MutableSet<Table> = mutableSetOf()

    public fun transaction(builder: TransactionBuilder.() -> (Unit)) {
        TransactionBuilder().apply(builder).builder()
    }

    public fun suspendableTransaction(builder: suspend (TransactionBuilder) -> Unit) {

    }

    /**
     * Creates any missing [Table] that were to otherwise not exist in the database.
     *
     * @param tables The tables that you want to create.
     *
     * @see Table
     * @since 0.0.1
     * @author yujin
     */
    public fun createMissingTables(vararg tables: Table): Tiramisu = apply {
        for (table in tables) {
            createTable(table.name ?: table.javaClass.simpleName).ifNotExists()
            registeredTables.add(table)
        }
    }

    /**
     * Creates any missing [Table] that were to otherwise not exist in the database.
     *
     * @param tables The tables that you want to create.
     *
     * @see Table
     * @since 0.0.1
     * @author yujin
     */
    public fun createMissingTables(tables: List<Table>): Tiramisu = apply {
        tables.forEach { table ->
            createTable(table.name ?: table.javaClass.simpleName).ifNotExists()
            registeredTables.add(table)
        }
    }
}