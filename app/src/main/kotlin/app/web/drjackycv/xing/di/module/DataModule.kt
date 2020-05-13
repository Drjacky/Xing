package app.web.drjackycv.xing.di.module

import dagger.Module

@Module(
    includes = [
        NetModule::class,
        ApiModule::class,
        RepositoryModule::class
    ]
)
class DataModule