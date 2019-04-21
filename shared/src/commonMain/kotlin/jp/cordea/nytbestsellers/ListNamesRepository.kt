package jp.cordea.nytbestsellers

internal class ListNamesRepository(
    private val remoteDataSource: ListNamesRemoteDataSource,
    private val localDataSource: ListNamesLocalDataSource
) {
    suspend fun getListNames(): ListNamesResponse =
        localDataSource.get() ?: remoteDataSource.getListNames().also { localDataSource.store(it) }
}
