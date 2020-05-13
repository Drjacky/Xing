package app.web.drjackycv.xing.di.module

import app.web.drjackycv.data.repos.datasource.ReposRemoteDataSource
import app.web.drjackycv.data.repos.repository.ReposRepositoryImpl
import app.web.drjackycv.domain.repos.repository.ReposRepository
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors

@Module
class RepositoryModule {

    @Suppress("PrivatePropertyName")
    private val NETWORK_IO = Executors.newFixedThreadPool(5)

    @Provides
    fun repos(reposRemoteDataSource: ReposRemoteDataSource): ReposRepository =
        ReposRepositoryImpl(reposRemoteDataSource, NETWORK_IO)

}