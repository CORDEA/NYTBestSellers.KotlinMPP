package jp.cordea.nytbestsellers

internal class ListsLocalDataSource {
    private var currentKey: String? = null
    private var response: ListsResponse? = null

    fun get(list: String) = if (currentKey == list) response else null

    fun find(position: Long) = response!!.results[position.toInt()]

    fun store(response: ListsResponse, list: String) {
        if (response.results.isEmpty()) {
            return
        }
        this.currentKey = list
        this.response = response
    }
}
