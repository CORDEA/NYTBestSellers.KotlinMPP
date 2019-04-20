package jp.cordea.nytbestsellers

class MainListItemModel(
    val title: String,
    val description: String
) {
    companion object {
        internal fun from(response: ListsResponse) =
            response
                .results
                .mapNotNull { it.bookDetails.firstOrNull() }
                .map { MainListItemModel(it.title, it.description) }
    }
}

internal fun ListsResponse.toModels() = MainListItemModel.from(this)
