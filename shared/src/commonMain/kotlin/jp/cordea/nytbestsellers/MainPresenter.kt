package jp.cordea.nytbestsellers

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

internal class MainPresenter(
    private val view: MainContract.View,
    private val listsRepository: ListsRepository,
    private val listNamesRepository: ListNamesRepository
) : MainContract.Presenter, CoroutineScope {
    private lateinit var job: Job

    override fun attach() {
        job = Job()
        launch {
            view.updateSpinnerItems(
                listNamesRepository.getListNames()
                    .results
                    .map { it.encodedName }
            )
        }
    }

    override fun loadItems(id: String) {
        launch {
            view.updateItems(
                listsRepository.getLists().toModels()
            )
        }
    }

    override fun detach() {
        job.cancel()
    }

    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job
}
