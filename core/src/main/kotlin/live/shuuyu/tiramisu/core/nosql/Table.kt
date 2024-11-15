package live.shuuyu.tiramisu.core.nosql

import kotlin.reflect.KClass

public open class Table(public val name: String?) {
    public open val tableName: String = name ?: javaClass.simpleName

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

public fun <T: Table> T.insert() {

}

public fun <T: Table> T.insertWithId() {

}

public fun <T: Table> T.upsert() {

}