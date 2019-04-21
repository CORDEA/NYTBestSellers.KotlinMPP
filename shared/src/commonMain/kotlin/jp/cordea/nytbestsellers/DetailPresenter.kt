package jp.cordea.nytbestsellers

internal class DetailPresenter(
    private val view: DetailContract.View,
    private val repository: ListsRepository
) : DetailContract.Presenter {
    override fun attachWith(position: Long) {
        view.render(repository.getList(position).toModel())
    }

    override fun detach() {
    }
}
