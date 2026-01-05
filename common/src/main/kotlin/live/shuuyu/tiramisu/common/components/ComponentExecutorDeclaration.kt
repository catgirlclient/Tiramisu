package live.shuuyu.tiramisu.common.components

import live.shuuyu.tiramisu.common.utils.Reflections

/**
 * Overarching class for declaring components alongside the messages.
 *
 * @param parent The parent class of the declaration (If there is one). Defaults to null if no value is provided.
 *  The declaration will attempt to use reflection in order to find the parent.
 * @param id The executor's ID. All IDs should be unique to avoid any conflicts.
 */
public open class ComponentExecutorDeclaration (
    public var parent: Any? = null,
    public val id: String,
    idRegex: Regex = ID_REGEX
) {
    private constructor(id: String, idRegex: Regex): this(null, id, idRegex)

    public companion object {
        public val ID_REGEX: Regex = Regex("[A-z0-9]+")
    }

    init {
        require(idRegex.matches(id)) { "ID must respect the $ID_REGEX regular expression!" }

        if (parent == null)
            parent = Reflections.getParentClass(this::class)
    }
}