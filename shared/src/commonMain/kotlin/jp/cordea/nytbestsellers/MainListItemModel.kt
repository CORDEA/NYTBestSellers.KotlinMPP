package jp.cordea.nytbestsellers

class MainListItemModel(
    val title: String,
    val description: String,
    val position: Long
) {
    companion object {
        internal fun from(response: ListsResponse) =
            response
                .results
                .mapNotNull { it.bookDetails.firstOrNull() }
                .mapIndexed { index, detail -> MainListItemModel(detail.title, detail.description, index.toLong()) }
    }
}

internal fun ListsResponse.toModels() = MainListItemModel.from(this)
