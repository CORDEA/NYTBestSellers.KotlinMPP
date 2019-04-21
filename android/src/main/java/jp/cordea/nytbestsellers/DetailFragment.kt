package jp.cordea.nytbestsellers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_detail.*
import org.koin.android.ext.android.getKoin
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class DetailFragment : Fragment(), DetailContract.View {
    val presenter = currentScope.inject<DetailContract.Presenter> { parametersOf(this@DetailFragment) }
    val titleStateDispatcher: Lazy<ActivityTitleStateDispatcher> =
        getKoin()
            .getScope(named<MainActivity>().toString())
            .inject()

    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_detail, container, false)

    override fun onResume() {
        super.onResume()
        presenter.value.attachWith(args.position)
    }

    override fun onPause() {
        super.onPause()
        presenter.value.detach()
    }

    override fun render(model: DetailModel) {
        description.text = model.description
        author.text = model.author
        publisher.text = model.publisher
        titleStateDispatcher.value.dispatch(model.title)
    }
}
