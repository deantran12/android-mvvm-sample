package com.sonth.mvvm.sample.di.module

import android.content.Context
import android.location.Geocoder
import androidx.biometric.BiometricPrompt
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sonth.mvvm.sample.SampleApp
import com.sonth.mvvm.sample.BuildConfig
import com.sonth.mvvm.sample.repository.AppRepositoryManager
import com.sonth.mvvm.sample.repository.RepositoryManager
import com.sonth.mvvm.sample.repository.auth.AppAuthenticationHelper
import com.sonth.mvvm.sample.repository.auth.AuthenticationHelper
import com.sonth.mvvm.sample.repository.local.AppWorkHelper
import com.sonth.mvvm.sample.repository.local.WorkHelper
import com.sonth.mvvm.sample.repository.remote.ApiHelper
import com.sonth.mvvm.sample.repository.remote.AppApiHelper
import com.sonth.mvvm.sample.repository.remote.EndpointApi
import com.sonth.mvvm.sample.repository.remote.EndpointService
import com.sonth.mvvm.sample.utils.MainThreadExecutor
import com.sonth.mvvm.sample.utils.SchedulerProvider
import com.sonth.mvvm.sample.utils.SharedConfig
import com.sonth.mvvm.sample.utils.provider.CryptoProvider
import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton


@Module
class AppModule {
    @Singleton
    @Provides
    fun provideScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    fun provideSchedulerProvider() = SchedulerProvider()

    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideContext(app: SampleApp): Context = app

    @Provides
    @Singleton
    fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    @Singleton
    fun provideWorkHelper(appWorkHelper: AppWorkHelper): WorkHelper = appWorkHelper

    @Provides
    @Singleton
    fun provideAuthHelper(appAuthHelper: AppAuthenticationHelper): AuthenticationHelper = appAuthHelper

    @Provides
    @Singleton
    fun provideDataManager(dataManager: AppRepositoryManager): RepositoryManager = dataManager


    //for list
    @Provides
    @Named("vertical")
    fun provideVerticalLinearLayoutManager(context: Context) = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

    @Provides
    @Named("horizontal")
    fun provideHorizontalLinearLayoutManager(context: Context) = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)

    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return BuildConfig.BASE_URL
    }

    @Singleton
    @Provides
    fun provideRetrofit(@Named("baseUrl") baseUrl: String): Retrofit {
        //logging
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)


        val okHttpClient = OkHttpClient().newBuilder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideEndpointApi(retrofit: Retrofit): EndpointApi {
        return EndpointApi(EndpointService(retrofit))
    }

    @Provides
    @Named("fileDir")
    fun provideFileDir(context: Context): File {
        return context.getExternalFilesDir(null) ?: context.cacheDir
    }

    @Provides
    fun provideGeocoder(context: Context): Geocoder{
        return Geocoder(context)
    }

    @Singleton
    @Provides
    fun provideCryptoProvider() : CryptoProvider{
        return CryptoProvider()
    }

    @Provides
    fun provideExecutor(): MainThreadExecutor {
        return MainThreadExecutor()
    }

    @Provides
    fun provideBiometricPromptInfo(): BiometricPrompt.PromptInfo {
        return BiometricPrompt.PromptInfo.Builder()
            .setTitle("Login")
            .setSubtitle("Login into your account")
            .setDescription("Touch your finger on the finger print sensor to authorise your account.")
            .setNegativeButtonText("Cancel")
            .build()
    }

    @Singleton
    @Provides
    fun provideSharedConfig(context: Context, gson: Gson): SharedConfig{
        return SharedConfig(context, gson)
    }

}