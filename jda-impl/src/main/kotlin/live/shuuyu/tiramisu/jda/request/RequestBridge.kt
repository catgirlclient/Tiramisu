package live.shuuyu.tiramisu.jda.request

import live.shuuyu.tiramisu.common.request.InteractionRequestState
import live.shuuyu.tiramisu.common.utils.Observable

public class RequestBridge(
    public val state: Observable<InteractionRequestState>
) {
    public var _manager: RequestManager? = null

    public var manager: RequestManager
        get() = _manager ?: throw IllegalArgumentException("RequestManager is null!")
        set(value) {
            _manager = value
        }
}