package app.web.drjackycv.data.repos.datasource

import android.annotation.SuppressLint
import androidx.paging.PageKeyedDataSource
import app.web.drjackycv.domain.base.entity.RecyclerItem
import javax.inject.Inject

@SuppressLint("CheckResult")
class ReposRemotePagedDataSource @Inject constructor(
    private val reposRemoteDataSource: ReposRemoteDataSource
) : PageKeyedDataSource<Int, RecyclerItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, RecyclerItem>
    ) {
        val currentPage = 1
        val nextPage = currentPage + 1

        reposRemoteDataSource.getRepos(
            page = currentPage,
            perPage = params.requestedLoadSize,
            onSuccess = { responseBody ->
                val items = responseBody ?: emptyList()
                callback.onResult(items, null, nextPage)
            })
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, RecyclerItem>) {
        val currentPage = params.key
        val nextPage = currentPage + 1

        reposRemoteDataSource.getRepos(
            page = currentPage,
            perPage = params.requestedLoadSize,
            onSuccess = { responseBody ->
                val items = responseBody ?: emptyList()
                callback.onResult(items, nextPage)
            })
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, RecyclerItem>) {}

}