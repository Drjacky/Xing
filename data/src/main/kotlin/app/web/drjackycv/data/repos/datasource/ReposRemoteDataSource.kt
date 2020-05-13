package app.web.drjackycv.data.repos.datasource

import app.web.drjackycv.data.network.BaseRemoteDataSource
import app.web.drjackycv.data.repos.remote.ReposApi
import app.web.drjackycv.domain.base.entity.RecyclerItem
import javax.inject.Inject

class ReposRemoteDataSource @Inject constructor(
    private val reposApi: ReposApi
) : BaseRemoteDataSource() {

    fun getRepos(
        page: Int = 1,
        perPage: Int,
        onSuccess: (List<RecyclerItem>?) -> Unit
    ) {
        val request = reposApi.getRepos(
            page = page,
            perPage = perPage
        )
        syncRequest(request, onSuccess)
    }

}