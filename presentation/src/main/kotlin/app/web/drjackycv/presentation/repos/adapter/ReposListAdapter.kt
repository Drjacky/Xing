package app.web.drjackycv.presentation.repos.adapter

import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.presentation.base.adapter.BasePagedListAdapter
import app.web.drjackycv.presentation.repos.entity.ItemCell

class ReposListAdapter(onItemClick: (RecyclerItem) -> Unit) : BasePagedListAdapter(
    ItemCell,
    onItemClick = onItemClick
)