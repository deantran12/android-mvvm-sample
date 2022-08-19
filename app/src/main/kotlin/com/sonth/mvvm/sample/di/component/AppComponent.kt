package com.sonth.mvvm.sample.di.component

import com.sonth.mvvm.sample.SampleApp
import com.sonth.mvvm.sample.di.builder.ActivityBuilder
import com.sonth.mvvm.sample.di.module.AppModule
import com.sonth.mvvm.sample.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(AndroidInjectionModule::class), (AppModule::class), (ViewModelModule::class), (ActivityBuilder::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: SampleApp): Builder

        fun build(): AppComponent
    }

    fun inject(app: SampleApp)

}