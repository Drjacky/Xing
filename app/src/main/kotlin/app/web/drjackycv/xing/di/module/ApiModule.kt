package app.web.drjackycv.xing.di.module

import app.web.drjackycv.data.repos.remote.ReposApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class ApiModule {

    @Provides
    fun repos(retrofit: Retrofit): ReposApi =
        retrofit.create(ReposApi::class.java)

}