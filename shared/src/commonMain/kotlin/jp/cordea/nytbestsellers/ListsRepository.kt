package jp.cordea.nytbestsellers

internal class ListsRepository(private val remoteDataSource: ListsRemoteDataSource) {
    suspend fun getLists(): ListsResponse = remoteDataSource.getLists()
}
