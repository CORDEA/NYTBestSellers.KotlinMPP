package jp.cordea.nytbestsellers

internal class ListsRemoteDataSource(private val apiClient: ApiClient) {
    suspend fun getLists(list: String): ListsResponse = apiClient.getLists(list)
}
