package jp.cordea.nytbestsellers

import kotlinx.serialization.Serializable

@Serializable
data class ListsResponse(
    val results: List<ListResponse>
)
