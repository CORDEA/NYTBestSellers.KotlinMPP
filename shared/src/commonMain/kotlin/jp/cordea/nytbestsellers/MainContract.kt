package jp.cordea.nytbestsellers

interface MainContract {
    interface View {
        fun updateSpinnerItems(items: List<String>)
        fun updateItems(items: List<MainListItemModel>)
        fun openDetail(position: Long)
    }

    interface Presenter {
        fun attach()
        fun loadItems(id: String)
        fun detach()
        fun showItemDetail(position: Long)
    }
}
