package app.web.drjackycv.presentation.repos.mapper

import app.web.drjackycv.domain.repos.entity.Item
import app.web.drjackycv.presentation.base.mapper.MapperUI
import app.web.drjackycv.presentation.repos.entity.ItemUI

class ItemMapper : MapperUI<Item, ItemUI> {

    override fun mapToUI(obj: Item): ItemUI = with(obj) {
        ItemUI(
            id = id,
            name = name,
            owner = OwnerMapper().mapToUI(owner),
            description = description,
            fork = fork
        )
    }

}