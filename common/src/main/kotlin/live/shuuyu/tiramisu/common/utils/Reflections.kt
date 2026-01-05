package live.shuuyu.tiramisu.common.utils

import io.github.oshai.kotlinlogging.KLogger
import io.github.oshai.kotlinlogging.KotlinLogging
import kotlin.reflect.KClass

public object Reflections {
    public val logger: KLogger = KotlinLogging.logger {}

    /**
     * Returns the parent function of the class declaring the function / initializing the class.
     * This should work on anonymous classes, inner classes, and companion objects.
     *
     * @return The parent class of the anonymous function/inner class/companion object.
     * @throws Exception If no parent class is available. This means that the user will have to manually input the parent
     *  class if there is one.
     *
     * @since 0.0.1
     */
    @JvmStatic
    public fun getParentClass(clazz: KClass<*>): KClass<out Any> {
        val parent = clazz.java.declaringClass ?: clazz.java.declaringClass.enclosingClass

        try {
            val parentClazz = clazz.java.classLoader.loadClass(parent.name)

            return parentClazz.kotlin
        } catch (e: Exception) {
            logger.error { "Couldn't load class ${parent.simpleName}! You may have to manually set the $clazz's variable!" }
            throw e
        }
    }
}