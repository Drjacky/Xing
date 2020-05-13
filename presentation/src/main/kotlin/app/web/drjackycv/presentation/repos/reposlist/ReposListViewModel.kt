package app.web.drjackycv.presentation.repos.reposlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations.switchMap
import androidx.paging.PagedList
import app.web.drjackycv.domain.base.entity.Listing
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.repos.usecase.GetReposListUseCase
import app.web.drjackycv.presentation.base.viewmodel.BaseViewModel
import javax.inject.Inject

class ReposListViewModel @Inject constructor(
    private val getReposListUseCase: GetReposListUseCase
) : BaseViewModel() {

    private val _ldReposList = MutableLiveData<Listing<RecyclerItem>>()
    val ldReposList: LiveData<PagedList<RecyclerItem>> = switchMap(_ldReposList) {
        loading(false)
        it.pagedList
    }

    fun getReposList() {
        loading(true)
        _ldReposList.postValue(getReposListUseCase(Unit))
    }

}