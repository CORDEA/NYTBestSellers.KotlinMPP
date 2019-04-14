package jp.cordea.nytbestsellers

interface MainContract {
    interface View {
        fun updateSpinnerItems(items: List<String>)
    }

    interface Presenter {
        fun attach()
        fun detach()
    }
}
