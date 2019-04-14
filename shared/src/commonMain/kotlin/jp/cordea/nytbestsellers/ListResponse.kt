package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListResponse(
    @SerialName("list_name") val name: String,
    @SerialName("display_name") val displayName: String,
    @SerialName("bestsellers_date") val bestsellersDate: String,
    @SerialName("published_date") val publishedDate: String,
    val rank: String,
    @SerialName("rank_last_week") val lastWeekRank: Int,
    @SerialName("weeks_on_list") val weeksOnList: Int,
    val asterisk: Int,
    val dagger: Int,
    @SerialName("amazon_product_url") val amazonProductUrl: String,
    val isbns: List<ListIsbnResponse>,
    @SerialName("book_details") val bookDetails: List<ListBookDetailResponse>,
    val reviews: List<ListReviewResponse>
)
