package jp.cordea.nytbestsellers

interface MainContract {
    interface View {
        fun updateSpinnerItems(items: List<String>)
        fun updateItems(items: List<MainListItemModel>)
    }

    interface Presenter {
        fun attach()
        fun loadItems(id: String)
        fun detach()
    }
}
