package jp.cordea.nytbestsellers

internal class ListsRepository(private val remoteDataSource: ListsRemoteDataSource) {
    suspend fun getLists(list: String): ListsResponse = remoteDataSource.getLists(list)
}
