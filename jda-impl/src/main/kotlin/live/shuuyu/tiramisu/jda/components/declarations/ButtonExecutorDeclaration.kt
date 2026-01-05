package live.shuuyu.tiramisu.jda.components.declarations

import live.shuuyu.tiramisu.common.components.ComponentExecutorDeclaration

public open class ButtonExecutorDeclaration (
    parent: Any? = null,
    id: String
): ComponentExecutorDeclaration(parent, id) {
    public constructor(id: String): this(null, id)
}