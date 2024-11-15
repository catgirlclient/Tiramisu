package live.shuuyu.tiramisu.core.utils

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.CqlSessionBuilder

public open class Session() {
    private val session: CqlSessionBuilder = CqlSession.builder()


}