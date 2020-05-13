package app.web.drjackycv.presentation.repos.entity

import app.web.drjackycv.domain.base.entity.RecyclerItem

data class ItemUI(
    override val id: Int,
    val name: String,
    val owner: OwnerUI,
    val description: String?,
    val fork: Boolean
) : RecyclerItem
