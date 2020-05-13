package app.web.drjackycv.xing.di.module

import androidx.lifecycle.ViewModelProvider
import app.web.drjackycv.presentation.base.viewmodel.BaseViewModel
import app.web.drjackycv.presentation.repos.reposlist.ReposListViewModel
import app.web.drjackycv.xing.di.viewmodel.ViewModelFactory
import app.web.drjackycv.xing.di.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun factory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(ReposListViewModel::class)
    abstract fun reposList(vm: ReposListViewModel): BaseViewModel

}