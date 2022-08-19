package com.sonth.mvvm.sample

import android.app.Application
import androidx.lifecycle.*
import com.sonth.mvvm.sample.di.component.DaggerAppComponent
import com.sonth.mvvm.sample.utils.LogUtil
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.reactivex.plugins.RxJavaPlugins
import javax.inject.Inject


class SampleApp : Application(), HasAndroidInjector, LifecycleEventObserver {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        LogUtil.init(BuildConfig.DEBUG)
        //for release
        LogUtil.isDebug = true
        performInject()
        //handle Rx error
        RxJavaPlugins.setErrorHandler{}
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)

    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun performInject(){
        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }


    private fun onAppBackgrounded() {
        //do something
    }

    private fun onAppForegrounded() {
        //do something
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        when(event){
            Lifecycle.Event.ON_STOP -> onAppBackgrounded()
            Lifecycle.Event.ON_START -> onAppForegrounded()
            else -> {}
        }
    }
}