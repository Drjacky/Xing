package app.web.drjackycv.domain.repos.usecase

import app.web.drjackycv.domain.base.entity.Listing
import app.web.drjackycv.domain.base.entity.RecyclerItem
import app.web.drjackycv.domain.base.usecase.GeneralUseCase
import app.web.drjackycv.domain.repos.repository.ReposRepository
import javax.inject.Inject

class GetReposListUseCase @Inject constructor(
    private val reposRepository: ReposRepository
) : GeneralUseCase<Listing<RecyclerItem>, Unit> {

    override fun invoke(params: Unit): Listing<RecyclerItem> =
        reposRepository.getRepos()

}