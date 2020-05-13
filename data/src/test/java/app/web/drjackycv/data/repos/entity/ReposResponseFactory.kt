package app.web.drjackycv.data.repos.entity

class ReposResponseFactory {

    companion object {
        fun providesItemsResponse() = listOf(providesItem(), providesItem(id = 240669))

        private fun providesItem(
            id: Int = 234107,
            name: String = "gearman-ruby"
        ) = ItemResponse(
            id = id,
            name = name,
            owner = providesOwner(),
            description = "Ruby library for the Gearman distributed job system",
            fork = true
        )

        private fun providesOwner(
            login: String = "xing",
            avatarUrl: String = "https://avatars2.githubusercontent.com/u/27901?v=4"
        ) = OwnerResponse(
            login = login,
            avatarUrl = avatarUrl
        )
    }

}