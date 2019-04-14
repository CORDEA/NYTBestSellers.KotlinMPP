package jp.cordea.nytbestsellers

internal class ListNamesRepository(private val dataSource: ListNamesRemoteDataSource) {
    suspend fun getListNames(): ListNamesResponse = dataSource.getListNames()
}
