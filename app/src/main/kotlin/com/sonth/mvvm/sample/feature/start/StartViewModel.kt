package com.sonth.mvvm.sample.feature.start

import com.sonth.mvvm.sample.base.BaseViewModel
import javax.inject.Inject

class StartViewModel @Inject constructor() : BaseViewModel() {
    companion object {
        const val NAV_ON_SIGNED_IN_GO_MAIN = 2
        const val NAV_ON_SIGNED_IN_SET_PASSCODE = 3
        const val NAV_ON_NOT_SIGNED_IN = 4
    }
    var inviteCode = ""

//    fun init() {
//        if (repositoryManager.getUser() == null) {
//            uiEventLiveData.value = NAV_ON_NOT_SIGNED_IN
//        } else {
//            repositoryManager.getUser()!!.let { user ->
//                setLoading(true)
//                if (user.isEmailVerified) {
//                    setLoading(false)
//                    val savedPasscode = sharedConfig.getPasscode()
//                    if(savedPasscode.isNotEmpty()) {
//                        uiEventLiveData.value = NAV_ON_SIGNED_IN_GO_MAIN
//                    }else{
//                        uiEventLiveData.value = NAV_ON_SIGNED_IN_SET_PASSCODE
//                    }
//                } else {
//                    tryReloadUser(repositoryManager.getUser()!!)
//                }
//            }
//        }
//    }
//
//    private fun tryReloadUser(firebaseUser: FirebaseUser) {
//        compositeDisposable.add(
//            repositoryManager.reloadUser(firebaseUser)
//                .compose(schedulerProvider.ioToMainObservableScheduler())
//                .subscribe(this::onReloadSuccess, this::onFailed)
//        )
//    }
//
//    private fun onReloadSuccess(result: Boolean) {
//        setLoading(false)
//        repositoryManager.getUser()?.run {
//            if (isEmailVerified) {
//                val savedPasscode = sharedConfig.getPasscode()
//                if(savedPasscode.isNotEmpty()) {
//                    uiEventLiveData.value = NAV_ON_SIGNED_IN_GO_MAIN
//                }else{
//                    uiEventLiveData.value = NAV_ON_SIGNED_IN_SET_PASSCODE
//                }
//            } else {
//                uiEventLiveData.value = NAV_ON_NOT_SIGNED_IN
//            }
//        }
//    }

    override fun onRefresh() {
        //do something
    }
}