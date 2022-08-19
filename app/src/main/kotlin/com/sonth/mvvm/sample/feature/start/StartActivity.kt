package com.sonth.mvvm.sample.feature.start

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.sonth.mvvm.sample.R
import com.sonth.mvvm.sample.base.BaseActivity
import com.sonth.mvvm.sample.base.BaseViewModel
import com.sonth.mvvm.sample.utils.CommonUtils
import com.sonth.mvvm.sample.BR
import com.sonth.mvvm.sample.base.Define
import com.sonth.mvvm.sample.databinding.ActivityStartBinding
import com.sonth.mvvm.sample.utils.LogUtil
import com.sonth.mvvm.sample.utils.ToastUtil
import io.covata.android.safeshare.di.ViewModelProviderFactory
import javax.inject.Inject

class StartActivity : BaseActivity<ActivityStartBinding, StartViewModel>() {

    @Inject
    lateinit var vmFactory: ViewModelProviderFactory
    private lateinit var startViewModel: StartViewModel

    override fun getViewModel(): StartViewModel {
        startViewModel = ViewModelProvider(this, vmFactory)[StartViewModel::class.java]
        return startViewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_start
    }

    override fun getBindingVariable(): Int {
        return BR.startVM
    }

    override fun updateUI(savedInstanceState: Bundle?) {
        startViewModel.getLoading()?.observe(this) { isLoading ->
            if (isLoading) {
                showLoadingDialog()
            } else {
                hideLoadingDialog()
            }
        }
        startViewModel.uiEventLiveData.observe(this) { event ->
            when (event) {
                BaseViewModel.BACK -> doFinishActivity()
                BaseViewModel.SHOW_ERROR -> showActionDialog(
                    null,
                    startViewModel.errorMessage, getString(android.R.string.ok), { _, _ ->
                        CommonUtils.restartApp(this)
                    }, null, null, false
                )
                BaseViewModel.SHOW_TOAST -> ToastUtil.showToast(
                    this,
                    startViewModel.toastMessage
                )
//                StartViewModel.NAV_ON_NOT_SIGNED_IN -> showAuthentication()
//                StartViewModel.NAV_ON_SIGNED_IN_GO_MAIN -> showMainScreen()
//                StartViewModel.NAV_ON_SIGNED_IN_SET_PASSCODE -> showSetPasscode()
            }
        }

//        setUpDynamicLink(intent)
    }

//    private fun showSetPasscode(){
//        goScreen(SetPasscodeActivity::class.java, true, R.anim.in_from_bottom, R.anim.fade_out)
//    }
//
//    private fun showMainScreen() {
//        val intent = Intent(this, QuickLoginActivity::class.java)
//        intent.putExtra(Define.INVITE_CODE, startViewModel.inviteCode)
//        launchIntent(
//            intent, true,
//            R.anim.slide_in_right,
//            R.anim.slide_out_left
//        )
//    }
//
//    private fun showAuthentication() {
//        openFragment(R.id.layoutContainer, AuthenticationFragment::class.java, null, true)
//    }
//
//    private fun showEmailVerification(code: String?) {
//        val intent = Intent(this, EmailVerificationActivity::class.java)
//        intent.putExtra(Define.OOB_CODE, code)
//        launchIntent(
//            intent, false,
//            R.anim.slide_in_right,
//            R.anim.slide_out_left
//        )
//    }
//
//    override fun onBackPressed() {
//        val count = supportFragmentManager.backStackEntryCount
//        if (count == 1) {
//            finish()
//            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
//        } else {
//            supportFragmentManager.popBackStackImmediate()
//        }
//    }
//
//    private fun showSetNewPassword(code: String?) {
//        val intent = Intent(this, SetNewPasswordActivity::class.java)
//        intent.putExtra(Define.OOB_CODE, code)
//        launchIntent(
//            intent, false,
//            R.anim.slide_in_right,
//            R.anim.slide_out_left
//        )
//    }
//
//    private fun setUpDynamicLink(intent: Intent) {
//        FirebaseDynamicLinks.getInstance()
//            .getDynamicLink(intent)
//            .addOnSuccessListener(this) { pendingDynamicLinkData ->
//                // Get deep link from result (may be null if no link is found)
//                if (pendingDynamicLinkData != null) {
//                    pendingDynamicLinkData.link?.let { deepLink ->
//                        val continueURL = deepLink.getQueryParameter("continueUrl") ?: ""
//                        val code = deepLink.getQueryParameter(Define.OOB_CODE)
//
//                        if (continueURL.contains(Constant.CONTINUE_URL_RESET)) {
//                            showSetNewPassword(code)
//                        } else if (continueURL.contains(Constant.CONTINUE_URL_VERIFY)) {
//                            showEmailVerification(code)
//                        }
//
//                        startViewModel.inviteCode = deepLink.getQueryParameter(Define.INVITE_CODE) ?: ""
//                    }
//                }
//
//                startViewModel.init()
//            }
//            .addOnFailureListener(this) { e ->
//                LogUtil.error("getDynamicLink:onFailure $e")
//                startViewModel.init()
//            }
//    }

}