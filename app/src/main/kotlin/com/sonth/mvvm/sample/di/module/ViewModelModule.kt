package com.sonth.mvvm.sample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sonth.mvvm.sample.feature.start.StartViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.covata.android.safeshare.di.ViewModelKey
import io.covata.android.safeshare.di.ViewModelProviderFactory

@Module
abstract class ViewModelModule{
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelProviderFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(StartViewModel::class)
    abstract fun provideStartViewModel(viewModel: StartViewModel): ViewModel


}