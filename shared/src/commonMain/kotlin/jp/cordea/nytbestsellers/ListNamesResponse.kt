package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListNamesResponse(
    val status: String,
    val copyright: String,
    @SerialName("num_results") val numberOfResults: Int,
    val results: List<ListNameResponse>
)
