package jp.cordea.nytbestsellers

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ListReviewResponse(
    @SerialName("book_review_link") val bookReviewLink: String,
    @SerialName("first_chapter_link") val firstChapterLink: String,
    @SerialName("sunday_review_link") val sundayReviewLink: String,
    @SerialName("article_chapter_link") val articleChapterLink: String
)
