package live.shuuyu.tiramisu.example

import live.shuuyu.tiramisu.core.Tiramisu
import live.shuuyu.tiramisu.core.nosql.Table
import live.shuuyu.tiramisu.core.utils.config.TiramisuConfig

public object TestDatabase {
    @JvmStatic
    private fun main(args: Array<String>) {
        Tiramisu.initialize(TiramisuConfig(address = ""))

        val database = Tiramisu().select(Table("name")) {

        }
    }
}