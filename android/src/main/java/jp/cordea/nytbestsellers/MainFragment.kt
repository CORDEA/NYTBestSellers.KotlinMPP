package jp.cordea.nytbestsellers


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.android.scope.currentScope
import org.koin.core.parameter.parametersOf

class MainFragment : Fragment(), MainContract.View {
    val presenter = currentScope.inject<MainContract.Presenter> { parametersOf(this@MainFragment) }

    private val adapter = GroupAdapter<ViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_main, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>) {
            }

            override fun onItemSelected(parent: AdapterView<*>, p1: View, p2: Int, p3: Long) {
                presenter.value.loadItems(parent.selectedItem.toString())
            }
        }

        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        presenter.value.attach()
    }

    override fun onPause() {
        super.onPause()
        presenter.value.detach()
    }

    override fun updateSpinnerItems(items: List<String>) {
        spinner.adapter = ArrayAdapter<String>(
            requireContext(),
            android.R.layout.simple_spinner_dropdown_item,
            items
        )
    }

    override fun updateItems(items: List<MainListItemModel>) {
        adapter.clear()
        adapter.addAll(items.map { MainListItem(it) })
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}
