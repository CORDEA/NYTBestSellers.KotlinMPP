package jp.cordea.nytbestsellers

import com.xwray.groupie.databinding.BindableItem
import jp.cordea.nytbestsellers.databinding.ListItemMainBinding

class MainListItem(private val model: MainListItemModel) : BindableItem<ListItemMainBinding>() {
    override fun getLayout(): Int = R.layout.list_item_main

    override fun bind(viewBinding: ListItemMainBinding, position: Int) {
        viewBinding.model = model
    }
}
