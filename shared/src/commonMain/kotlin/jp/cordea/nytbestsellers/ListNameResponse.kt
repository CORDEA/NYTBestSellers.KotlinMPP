package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListNameResponse(
    @SerialName("list_name") val name: String,
    @SerialName("display_name") val displayName: String,
    @SerialName("list_name_encoded") val encodedName: String,
    @SerialName("oldest_published_date") val oldestPublishedDate: String,
    @SerialName("newest_published_date") val newestPublishedDate: String,
    @SerialName("updated") val updated: String
)
