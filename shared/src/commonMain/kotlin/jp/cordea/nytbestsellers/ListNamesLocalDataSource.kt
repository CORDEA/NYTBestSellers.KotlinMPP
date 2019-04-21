package jp.cordea.nytbestsellers

internal class ListNamesLocalDataSource {
    private var response: ListNamesResponse? = null

    fun get() = response

    fun store(response: ListNamesResponse) {
        if (response.results.isEmpty()) {
            return
        }
        this.response = response
    }
}
