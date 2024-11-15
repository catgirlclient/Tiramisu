package live.shuuyu.tiramisu.core.utils

import kotlin.reflect.KProperty1

public interface Expressions {

}

public fun <S, R> KProperty1<S, R>.eq(value: S): Boolean {
    return this == value
}
