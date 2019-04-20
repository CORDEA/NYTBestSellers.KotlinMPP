package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListsResponse(
    val status: String,
    val copyright: String,
    @SerialName("num_results") val numberOfResults: Int,
    @SerialName("last_modified") val lastModified: String,
    val results: List<ListResponse>
)
