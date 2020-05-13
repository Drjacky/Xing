package app.web.drjackycv.domain.repos.entity

import androidx.lifecycle.MutableLiveData
import app.web.drjackycv.domain.base.entity.Listing
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.repos.extension.mockPagedList

class ReposFactory {

    companion object {
        private val pagedList = mockPagedList(listOf(providesItem() as RecyclerItem))

        fun providesItems() = Listing(MutableLiveData(pagedList))

        private fun providesItem(
            id: Int = 234107,
            name: String = "gearman-ruby"
        ) = Item(
            id = id,
            name = name,
            owner = providesOwner(),
            description = "Ruby library for the Gearman distributed job system",
            fork = true
        )

        private fun providesOwner(
            login: String = "xing",
            avatarUrl: String = "https://avatars2.githubusercontent.com/u/27901?v=4"
        ) = Owner(
            login = login,
            avatarUrl = avatarUrl
        )
    }

}