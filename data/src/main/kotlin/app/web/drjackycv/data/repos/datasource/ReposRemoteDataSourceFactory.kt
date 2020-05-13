package app.web.drjackycv.data.repos.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import app.web.drjackycv.domain.base.entity.RecyclerItem

class ReposRemoteDataSourceFactory(
    private val reposRemoteDataSource: ReposRemoteDataSource
) : DataSource.Factory<Int, RecyclerItem>() {

    val source = MutableLiveData<ReposRemotePagedDataSource>()

    override fun create(): DataSource<Int, RecyclerItem> {
        val source = ReposRemotePagedDataSource(reposRemoteDataSource)
        this.source.postValue(source)
        return source
    }

}