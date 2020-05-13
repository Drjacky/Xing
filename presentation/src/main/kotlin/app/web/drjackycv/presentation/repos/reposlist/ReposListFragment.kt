package app.web.drjackycv.presentation.repos.reposlist

import android.os.Bundle
import android.view.View
import androidx.paging.PagedList
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.base.exception.Failure
import app.web.drjackycv.presentation.R
import app.web.drjackycv.presentation.base.fragment.BaseFragment
import app.web.drjackycv.presentation.extension.gone
import app.web.drjackycv.presentation.extension.observe
import app.web.drjackycv.presentation.extension.viewModel
import app.web.drjackycv.presentation.extension.visible
import app.web.drjackycv.presentation.repos.adapter.ReposListAdapter
import kotlinx.android.synthetic.main.fragment_repos_list.*
import kotlinx.android.synthetic.main.item_error.*
import kotlinx.android.synthetic.main.progress_bar_circular.*

class ReposListFragment : BaseFragment() {

    override var fragmentLayout: Int = R.layout.fragment_repos_list

    private lateinit var reposListViewModel: ReposListViewModel

    private val reposListAdapter: ReposListAdapter by lazy {
        ReposListAdapter {}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupViewModel()
    }

    private fun setupRecycler() {
        itemErrorContainer.gone()
        reposListRecyclerView.adapter = reposListAdapter
    }

    private fun setupViewModel() {
        reposListViewModel = viewModel(viewModelFactory.get()) {

            getReposList()

            observe(ldReposList, ::addRepos)

            observe(ldLoading, ::loadingUI)

            observe(ldFailure, ::handleFailure)

        }
    }

    private fun addRepos(reposList: PagedList<RecyclerItem>) {
        itemErrorContainer.gone()
        reposListRecyclerView.visible()
        reposListAdapter.submitList(reposList)
    }

    private fun loadingUI(isLoading: Boolean) {
        if (isLoading) {
            itemErrorContainer.gone()
            progressBar.visible()
        } else {
            progressBar.gone()
        }
    }

    private fun handleFailure(failure: Failure) {
        when (failure) {
            is Failure.FailureWithMessage -> {
                reposListRecyclerView.gone()
                itemErrorContainer.visible()
                itemErrorMessage.text = failure.msg
                itemErrorRetryBtn.setOnClickListener { failure.retryAction() }
            }
        }
    }

}