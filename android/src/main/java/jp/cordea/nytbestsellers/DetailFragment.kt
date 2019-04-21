package jp.cordea.nytbestsellers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class DetailFragment : Fragment(), DetailContract.View {
    val presenter = currentScope.inject<DetailContract.Presenter> { parametersOf(this@DetailFragment) }

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
    }

    companion object {
        fun newInstance() = DetailFragment()
    }
}
