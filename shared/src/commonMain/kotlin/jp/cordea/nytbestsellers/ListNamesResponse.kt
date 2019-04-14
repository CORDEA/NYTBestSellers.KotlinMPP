package jp.cordea.nytbestsellers

import kotlinx.serialization.Serializable

@Serializable
data class ListNamesResponse(
    val results: List<ListNameResponse>
)
