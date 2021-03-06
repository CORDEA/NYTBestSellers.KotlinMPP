package jp.cordea.nytbestsellers

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import org.koin.android.scope.currentScope
import org.koin.core.qualifier.named
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {
    override val coroutineContext: CoroutineContext get() = Dispatchers.Main + job

    private lateinit var job: Job

    val titleStateStore = currentScope.inject<ActivityTitleStateStore>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        job = Job()
        launch {
            val titles = titleStateStore.value.onTitleChanged
            for (title in titles) {
                toolbar.title = title
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun toString(): String = named<MainActivity>().toString()

    override fun onSupportNavigateUp(): Boolean = findNavController(R.layout.activity_main).navigateUp()
}
