package jp.cordea.nytbestsellers

interface DetailContract {
    interface View {
        fun render(model: DetailModel)
    }

    interface Presenter {
        fun attachWith(position: Long)
        fun detach()
    }
}
