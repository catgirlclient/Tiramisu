package live.shuuyu.tiramisu.common.utils

import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume

public class Observable<T>(value: T) {
    public var value: T = value
        set(value) {
            field = value
            val currentListeners = listeners.toList()
            listeners.clear()
            currentListeners.forEach {
                it.resume(value)
            }
        }

    private val listeners = mutableListOf<Continuation<T>>()

    public suspend fun awaitChange(): T {
        return suspendCancellableCoroutine {
            listeners.add(it)
        }
    }
}