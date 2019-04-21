package jp.cordea.nytbestsellers

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel

interface ActivityTitleStateStore {
    val onTitleChanged: ReceiveChannel<String>
}

interface ActivityTitleStateDispatcher {
    fun dispatch(title: String)
}

class ActivityTitleState : ActivityTitleStateStore, ActivityTitleStateDispatcher {
    private val _onTitleChanged = Channel<String>()
    override val onTitleChanged: ReceiveChannel<String> = _onTitleChanged

    override fun dispatch(title: String) {
        _onTitleChanged.offer(title)
    }
}
