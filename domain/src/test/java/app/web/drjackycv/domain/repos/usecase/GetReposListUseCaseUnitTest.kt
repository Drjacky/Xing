package app.web.drjackycv.domain.repos.usecase

import app.web.drjackycv.domain.repos.entity.ReposFactory.Companion.providesItems
import app.web.drjackycv.domain.repos.extension.assertGeneralsError
import app.web.drjackycv.domain.repos.extension.assertGeneralsSuccess
import app.web.drjackycv.domain.repos.extension.testAwait
import app.web.drjackycv.domain.repos.repository.ReposRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetReposListUseCaseUnitTest {

    private lateinit var getReposListUseCase: GetReposListUseCase

    @Mock
    private lateinit var reposRepository: ReposRepository

    @Before
    fun setUp() {
        getReposListUseCase = GetReposListUseCase(reposRepository)
    }

    @Test
    fun `invoke should return list of repositories`() {
        whenever(reposRepository.getRepos())
            .doReturn(providesItems())

        val testObserver = Single.just(getReposListUseCase(Unit)).testAwait()

        testObserver.assertGeneralsSuccess {
            it.pagedList.value?.isNotEmpty() == true
        }
    }

    @Test
    fun `invoke should not return list of repositories in case of an error`() {
        whenever(reposRepository.getRepos())
            .doReturn(providesItems())

        val testObserver = Single.just(getReposListUseCase(Unit)).testAwait()

        testObserver.assertGeneralsError()
    }

}