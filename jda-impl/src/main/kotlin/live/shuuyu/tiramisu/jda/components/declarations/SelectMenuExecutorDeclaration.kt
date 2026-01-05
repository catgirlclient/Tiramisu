package live.shuuyu.tiramisu.jda.components.declarations

import live.shuuyu.tiramisu.common.components.ComponentExecutorDeclaration
import kotlin.reflect.KClass

public open class SelectMenuExecutorDeclaration (
    parent: KClass<*>? = null,
    id: String
): ComponentExecutorDeclaration(parent, id) {
    public constructor(id: String): this(null, id)
}