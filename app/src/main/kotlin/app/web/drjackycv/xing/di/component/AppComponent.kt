package app.web.drjackycv.xing.di.component

import app.web.drjackycv.xing.application.XingApplication
import app.web.drjackycv.xing.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        DataModule::class,
        ActivityModule::class,
        ViewModelModule::class,
        FragmentModule::class
    ]
)
interface AppComponent : AndroidInjector<XingApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: XingApplication): Builder

        fun build(): AppComponent

    }

}