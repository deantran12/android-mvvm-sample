package com.sonth.mvvm.sample.base

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.sonth.mvvm.sample.R
import com.sonth.mvvm.sample.data.remote.ErrorResponse
import com.sonth.mvvm.sample.repository.RepositoryManager
import com.sonth.mvvm.sample.utils.SchedulerProvider
import com.sonth.mvvm.sample.utils.SharedConfig
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import retrofit2.HttpException
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    companion object {
        const val SHOW_TOAST = -2
        const val FINISH_ACTIVITY = -1
        const val BACK = 0
        const val SHOW_ERROR = 1
    }

    @Inject
    lateinit var repositoryManager: RepositoryManager

    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    @Inject
    lateinit var gson: Gson

    @Inject
    lateinit var sharedConfig: SharedConfig

    var compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val mIsLoading = SingleLiveData<Boolean>()
    val uiEventLiveData = SingleLiveData<Int>()
    var errorMessage: Any = "Unknown error"
    var toastMessage: Any = "Unknown message"

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }

    fun launch(job: () -> Disposable) {
        compositeDisposable.add(job())
    }

    fun isLoading(): Boolean {
        return mIsLoading.value ?: false
    }

    fun getLoading(): SingleLiveData<Boolean>? {
        return mIsLoading
    }

    fun setLoading(isLoading: Boolean) {
        mIsLoading.value = isLoading
    }

    open fun handleError(t: Throwable): Any {
        if (t is HttpException) {
            t.response()?.errorBody()?.let { body ->
                try {
                    return gson.fromJson(body.string(), ErrorResponse::class.java).message
                }catch (_: JsonSyntaxException){}
            }
        }
//        when(t.cause){
//            is FirebaseAuthUserCollisionException -> return R.string.error_email_already_registered
//            is FirebaseAuthInvalidCredentialsException -> return R.string.error_wrong_credentials
//            is FirebaseTooManyRequestsException -> return R.string.error_too_many_verification_request
//        }
//        if (t.message != null) {
//            return t.message!!
//        }
        return R.string.generic_error_message
    }

    fun showError(message: Any) {
        errorMessage = message
        uiEventLiveData.value = SHOW_ERROR
    }

    fun showToast(message: Any) {
        toastMessage = message
        uiEventLiveData.value = SHOW_TOAST
    }

    fun performBack() {
        uiEventLiveData.value = BACK
    }

    abstract fun onRefresh()

    open fun onFailed(throwable: Throwable) {
        setLoading(false)
        showError(handleError(throwable))
    }
}