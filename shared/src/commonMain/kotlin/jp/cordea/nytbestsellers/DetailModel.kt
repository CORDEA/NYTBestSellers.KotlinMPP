package jp.cordea.nytbestsellers

class DetailModel(
    val title: String,
    val description: String,
    val author: String,
    val publisher: String
) {
    companion object {
        internal fun from(response: ListResponse) =
            response.bookDetails.first().run {
                DetailModel(
                    title,
                    description,
                    author,
                    publisher
                )
            }
    }
}

internal fun ListResponse.toModel() = DetailModel.from(this)
