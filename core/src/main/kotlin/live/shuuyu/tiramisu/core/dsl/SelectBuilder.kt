package live.shuuyu.tiramisu.core.dsl

import com.datastax.oss.driver.api.querybuilder.QueryBuilder.selectFrom
import com.datastax.oss.driver.api.querybuilder.select.Select
import com.datastax.oss.driver.api.querybuilder.select.SelectFrom
import com.datastax.oss.driver.shaded.guava.common.base.Predicate
import live.shuuyu.tiramisu.core.nosql.Table
import kotlin.reflect.KProperty1

public open class SelectBuilder(table: Table) {
    public var selectTable: SelectFrom = selectFrom(table.tableName)
    protected var where: Predicate<*>? = null

    public fun where(predicate: () -> KProperty1<*, Boolean>): Select {
        require(where == null)

        return selectTable.all().where(

        )
    }
}