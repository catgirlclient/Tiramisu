package live.shuuyu.tiramisu.core.dsl

import com.datastax.oss.driver.api.querybuilder.QueryBuilder.bindMarker
import com.datastax.oss.driver.api.querybuilder.QueryBuilder.insertInto
import com.datastax.oss.driver.api.querybuilder.insert.InsertInto
import live.shuuyu.tiramisu.core.nosql.Table

public open class InsertBuilder(table: Table) {
    public var insertTable: InsertInto = insertInto(table.tableName)

    /**
     * Generates a TTL (**T**ime **T**o **L**ive) clause causing the inserted value to expire within the given time.
     * After the time has elapsed, the column will be deleted/marked with a tombstone.
     *
     * @param value The seconds until the column is tombstoned.
     *
     * @see <a href="https://java-driver.docs.scylladb.com/stable/manual/query_builder/insert/index.html">ScyllaDB Java Documents</a>
     * @since 0.0.1
     * @author yujin
     */
    public fun usingTTL(value: Int) {
        insertTable.value("a", bindMarker()).usingTimestamp(value.toLong())
    }
}