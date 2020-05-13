package app.web.drjackycv.presentation.repos.entity

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.repos.entity.Item
import app.web.drjackycv.presentation.R
import app.web.drjackycv.presentation.base.adapter.Cell
import app.web.drjackycv.presentation.repos.mapper.ItemMapper

object ItemCell : Cell<RecyclerItem>() {

    override fun belongsTo(item: RecyclerItem?): Boolean {
        return item is Item
    }

    override fun type(): Int {
        return R.layout.item_repo
    }

    override fun holder(parent: ViewGroup): RecyclerView.ViewHolder {
        return ItemViewHolder(parent.viewOf(type()))
    }

    override fun bind(
        holder: RecyclerView.ViewHolder,
        item: RecyclerItem?,
        onItemClick: ((RecyclerItem) -> Unit)?
    ) {
        if (holder is ItemViewHolder && item is Item) {
            val itemUI = ItemMapper().mapToUI(item)
            holder.bind(itemUI)
            holder.itemView.setOnClickListener {
                onItemClick?.run { this(item) }
            }
        }
    }

}