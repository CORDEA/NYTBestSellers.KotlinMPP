package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListBookDetailResponse(
    val title: String,
    val description: String,
    val contributor: String,
    val author: String,
    @SerialName("contributor_note") val contributorNote: String,
    val price: Int,
    @SerialName("age_group") val ageGroup: String,
    val publisher: String,
    @SerialName("primary_isbn13") val primaryIsbn13: String,
    @SerialName("primary_isbn10") val primaryIsbn10: String
)
