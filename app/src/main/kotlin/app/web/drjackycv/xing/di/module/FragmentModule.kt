package app.web.drjackycv.xing.di.module

import app.web.drjackycv.mvvmtemplate.di.scope.PerView
import app.web.drjackycv.presentation.repos.reposlist.ReposListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @PerView
    @ContributesAndroidInjector
    abstract fun reposList(): ReposListFragment

}