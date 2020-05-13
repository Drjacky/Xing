package app.web.drjackycv.domain.repos.repository

import app.web.drjackycv.domain.base.entity.Listing
import app.web.drjackycv.domain.base.entity.RecyclerItem


interface ReposRepository {

    fun getRepos(): Listing<RecyclerItem>

}