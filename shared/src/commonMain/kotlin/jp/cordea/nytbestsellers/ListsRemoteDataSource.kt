package jp.cordea.nytbestsellers

internal class ListsRemoteDataSource(private val apiClient: ApiClient) {
    suspend fun getLists(): ListsResponse = apiClient.getLists()
}
