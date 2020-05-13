package app.web.drjackycv.domain.repos.entity

import app.web.drjackycv.domain.base.entity.RecyclerItem

data class Item(
    override val id: Int,
    val name: String,
    val owner: Owner,
    val description: String?,
    val fork: Boolean
) : RecyclerItem
