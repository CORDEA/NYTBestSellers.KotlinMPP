package jp.cordea.nytbestsellers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.ext.android.getKoin
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

class MainFragment : Fragment(), MainContract.View {
    val presenter = currentScope.inject<MainContract.Presenter> { parametersOf(this@MainFragment) }
    val titleStateDispatcher: Lazy<ActivityTitleStateDispatcher> =
        getKoin()
            .getScope(named<MainActivity>().toString())
            .inject()

    private val adapter = GroupAdapter<ViewHolder>()
    private val listener = object : AdapterView.OnItemSelectedListener {
        override fun onNothingSelected(parent: AdapterView<*>) {
        }

        override fun onItemSelected(parent: AdapterView<*>, p1: View?, p2: Int, p3: Long) {
            presenter.value.loadItems(parent.selectedItem.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.adapter = adapter
        adapter.setOnItemClickListener { item, _ ->
            presenter.value.showItemDetail(item.id)
        }

        savedInstanceState?.getString(STATE_KEY)?.let {
            presenter.value.storeCurrentKey(it)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.value.attach()
        titleStateDispatcher.value.dispatch(getString(R.string.app_name))
    }

    override fun onPause() {
        super.onPause()
        presenter.value.detach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_KEY, presenter.value.currentKey)
    }

    override fun updateSpinnerItems(items: List<String>) {
        spinner.onItemSelectedListener = null
        spinner.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            items
        )
        spinner.onItemSelectedListener = listener
        val index = items.indexOfFirst { it == presenter.value.currentKey }
        spinner.setSelection(if (index >= 0) index else 0)
    }

    override fun updateItems(items: List<MainListItemModel>) {
        adapter.clear()
        adapter.addAll(items.map { MainListItem(it) })
    }

    override fun openDetail(position: Long) {
        findNavController().navigate(
            MainFragmentDirections
                .actionMainFragmentToDetailFragment()
                .setPosition(position)
        )
    }

    companion object {
        private const val STATE_KEY = "STATE_KEY"
    }
}
