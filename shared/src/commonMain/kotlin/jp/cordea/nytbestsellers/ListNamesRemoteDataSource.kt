package jp.cordea.nytbestsellers

internal class ListNamesRemoteDataSource(private val apiClient: ApiClient) {
    suspend fun getListNames(): ListNamesResponse = apiClient.getListNames()
}
