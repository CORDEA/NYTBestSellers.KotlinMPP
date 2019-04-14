package jp.cordea.nytbestsellers

import kotlinx.serialization.Serializable

@Serializable
data class ListIsbnResponse(
    val isbn13: String,
    val isbn10: String
)
