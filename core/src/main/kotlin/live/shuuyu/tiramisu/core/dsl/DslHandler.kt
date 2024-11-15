package live.shuuyu.tiramisu.core.dsl

import com.datastax.oss.driver.api.core.CqlSession
import live.shuuyu.tiramisu.core.nosql.Table

public open class DslHandler(public val session: CqlSession) {
    public fun insert(
        table: Table,
        builder: InsertBuilder.() -> (Unit) = {}
    ): InsertBuilder = InsertBuilder(table)
        .apply(builder)

    public fun upsert(
        table: Table,
        builder: UpsertBuilder.() -> (Unit) = {}
    ): UpsertBuilder = UpsertBuilder(table)
        .apply(builder)

    public fun select(
        table: Table,
        builder: SelectBuilder.() -> (Unit) = {}
    ): SelectBuilder = SelectBuilder(table)
        .apply(builder)

    public fun delete(
        table: Table,
        builder: DeleteBuilder.() -> (Unit) = {}
    ): DeleteBuilder = DeleteBuilder(table)
        .apply(builder)
}