package app.web.drjackycv.data.repos.repository

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import app.web.drjackycv.data.repos.datasource.ReposRemoteDataSource
import app.web.drjackycv.data.repos.datasource.ReposRemoteDataSourceFactory
import app.web.drjackycv.domain.base.entity.Listing
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.repos.repository.ReposRepository
import java.util.concurrent.Executor
import javax.inject.Inject

class ReposRepositoryImpl @Inject constructor(
    private val reposRemoteDataSource: ReposRemoteDataSource,
    private val networkExecutor: Executor
) : ReposRepository {

    override fun getRepos(): Listing<RecyclerItem> {
        val factory = reposRemoteDataSourceFactory()
        val config = pagedListConfig()
        val livePagedList: LiveData<PagedList<RecyclerItem>> = LivePagedListBuilder(factory, config)
            .setFetchExecutor(networkExecutor)
            .build()

        return Listing(livePagedList)
    }


    private fun pagedListConfig(pageSize: Int = 7): PagedList.Config {
        return PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(pageSize)
            .setPageSize(pageSize)
            .build()
    }

    private fun reposRemoteDataSourceFactory() =
        ReposRemoteDataSourceFactory(reposRemoteDataSource)

}