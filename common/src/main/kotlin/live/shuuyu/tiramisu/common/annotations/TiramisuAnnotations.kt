package live.shuuyu.tiramisu.common.annotations

@DslMarker
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS)
public annotation class TiramisuDsl

@RequiresOptIn(
    "This class/function/property was never meant for external use. It's advised to avoid the usage of such functionality.",
    level = RequiresOptIn.Level.ERROR
)
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY)
public annotation class TiramisuInternal