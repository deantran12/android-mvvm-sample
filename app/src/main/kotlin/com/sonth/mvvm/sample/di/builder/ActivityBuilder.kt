package com.sonth.mvvm.sample.di.builder

import com.sonth.mvvm.sample.feature.start.StartActivity
import com.sonth.mvvm.sample.feature.start.StartProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [StartProvider::class])
    abstract fun bindStartActivity(): StartActivity

}
