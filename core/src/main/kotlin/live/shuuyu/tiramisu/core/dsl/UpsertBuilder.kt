package live.shuuyu.tiramisu.core.dsl

import com.datastax.oss.driver.api.querybuilder.QueryBuilder.update
import com.datastax.oss.driver.api.querybuilder.update.UpdateStart
import live.shuuyu.tiramisu.core.nosql.Table

public open class UpsertBuilder(table: Table) {
    public var updatedTable: UpdateStart = update(table.tableName)

    public fun usingTimestamp(value: Long): UpdateStart = updatedTable.usingTimestamp(value)
}