package live.shuuyu.kassandra.core.nosql

import kotlin.reflect.KClass

public abstract class Table(public val name: String) {
    public fun string(name: String) {}
    public fun boolean(name: String) {}
    public fun int(name: String) {}
    public fun long(name: String) {}
    public fun ulong(name: String) {}
    public fun short(name: String) {}
    public fun ushort(name: String) {}
    public fun float(name: String) {}
    public fun <T: Any> array(name: String, type: KClass<T>) {}
    public fun <T: Any> enumeration(name: String, type: KClass<T>) {}
}