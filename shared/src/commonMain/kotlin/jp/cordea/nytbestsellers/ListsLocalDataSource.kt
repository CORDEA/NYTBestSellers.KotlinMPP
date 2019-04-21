package jp.cordea.nytbestsellers

internal class ListsLocalDataSource {
    private var response: List<ListResponse> = emptyList()

    fun find(position: Long) = response[position.toInt()]

    fun store(response: ListsResponse) {
        if (response.results.isEmpty()) {
            return
        }
        this.response = response.results
    }
}
