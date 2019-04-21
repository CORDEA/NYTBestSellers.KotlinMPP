package jp.cordea.nytbestsellers

internal class ListsRepository(
    private val remoteDataSource: ListsRemoteDataSource,
    private val localDataSource: ListsLocalDataSource
) {
    suspend fun getLists(list: String): ListsResponse =
        remoteDataSource.getLists(list).also { localDataSource.store(it) }

    fun getList(position: Long): ListResponse =
        localDataSource.find(position)
}
