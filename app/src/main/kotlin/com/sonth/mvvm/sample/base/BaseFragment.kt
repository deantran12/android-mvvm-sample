package com.sonth.mvvm.sample.base

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.sonth.mvvm.sample.R
import com.sonth.mvvm.sample.utils.KeyboardUtil
import dagger.android.support.AndroidSupportInjection
import org.greenrobot.eventbus.EventBus

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel> : Fragment() {

    var rootView: View? = null
    private var _binding: T? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    val binding get() = _binding!!

    protected abstract fun getViewModel(): V

    @LayoutRes
    abstract fun getLayoutId(): Int

    protected abstract fun getBindingVariable(): Int

    /**
     * update screen
     *
     * @param savedInstanceState
     */
    protected abstract fun updateUI(savedInstanceState: Bundle?)

    open fun getThemResId(): Int = R.style.CustomDialog
    lateinit var loading: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        performDI()
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layoutId = getLayoutId()
        _binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        rootView = binding.root
        binding.setVariable(getBindingVariable(), getViewModel())
        binding.lifecycleOwner = viewLifecycleOwner
        binding.executePendingBindings()
        updateUI(savedInstanceState)
        initDialog()
        return rootView
    }

    private fun performDI() {
        AndroidSupportInjection.inject(this)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    @Throws
    open fun openFragment(
        resId: Int,
        fragmentClazz: Class<*>,
        args: Bundle?,
        addBackStack: Boolean
    ) {
        val tag = fragmentClazz.simpleName
        try {
            val isExisted =
                childFragmentManager.findFragmentByTag(tag) != null   // IllegalStateException
            if (!isExisted) {
                val fragment: Fragment
                try {
                    fragment =
                        (fragmentClazz as Class<Fragment>).newInstance().apply { arguments = args }

                    val transaction = childFragmentManager.beginTransaction()
                    transaction.add(resId, fragment, tag)

                    if (addBackStack) {
                        transaction.addToBackStack(tag)
                    }
                    transaction.commitAllowingStateLoss()

                } catch (e: java.lang.InstantiationException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws
    open fun openFragment(
        resId: Int, fragmentClazz: Class<*>, args: Bundle?, addBackStack: Boolean,
        vararg aniInt: Int
    ) {
        val tag = fragmentClazz.simpleName
        try {
            val isExisted =
                childFragmentManager.findFragmentByTag(tag) != null    // IllegalStateException
            if (!isExisted) {
                val fragment: Fragment
                try {
                    fragment =
                        (fragmentClazz as Class<Fragment>).newInstance().apply { arguments = args }

                    val transaction = childFragmentManager.beginTransaction()
                    transaction.setCustomAnimations(aniInt[0], aniInt[1], aniInt[2], aniInt[3])
                    transaction.add(resId, fragment, tag)

                    if (addBackStack) {
                        transaction.addToBackStack(tag)
                    }
                    transaction.commitAllowingStateLoss()

                } catch (e: java.lang.InstantiationException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @Throws
    open fun openFragmentFromActivity(
        resId: Int, fragmentClazz: Class<*>, args: Bundle?, addBackStack: Boolean,
        vararg aniInt: Int
    ) {
        val tag = fragmentClazz.simpleName
        try {
            val isExisted =
                requireActivity().supportFragmentManager.findFragmentByTag(tag) != null    // IllegalStateException
            if (!isExisted) {
                val fragment: Fragment
                try {
                    fragment =
                        (fragmentClazz as Class<Fragment>).newInstance().apply { arguments = args }

                    val transaction = requireActivity().supportFragmentManager.beginTransaction()
                    transaction.setCustomAnimations(aniInt[0], aniInt[1], aniInt[2], aniInt[3])
                    transaction.add(resId, fragment, tag)

                    if (addBackStack) {
                        transaction.addToBackStack(tag)
                    }
                    transaction.commitAllowingStateLoss()

                } catch (e: java.lang.InstantiationException) {
                    e.printStackTrace()
                } catch (e: IllegalAccessException) {
                    e.printStackTrace()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun toast(msg: String) {
        context?.let {
            Toast.makeText(it, msg, Toast.LENGTH_SHORT).show()
        }
    }

    fun onBack(tag: String, vararg aniInt: Int) {
        val fragment = parentFragmentManager.findFragmentByTag(tag)
        fragment?.let {
            parentFragmentManager
                .beginTransaction()
                .disallowAddToBackStack()
                .setCustomAnimations(aniInt[0], aniInt[1])
                .remove(it)
                .commitNow()
            KeyboardUtil.hideSoftKeyBoard(requireActivity())
        }
    }

    open fun onBack(){
        activity?.let{
            KeyboardUtil.hideSoftKeyBoard(it)
        }
        parentFragmentManager.popBackStackImmediate()
    }

    fun showMessageDialog(context: Context, title: String?, message: Any){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        if(message is Int){
            builder.setMessage(message)
        }else if(message is String){
            builder.setMessage(message)
        }
        builder.setPositiveButton(android.R.string.ok, null)
        builder.setCancelable(true)
        builder.show()
    }

    fun showActionDialog(context: Context, title: String?, message: Any, positiveAction: String, positiveListener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        if (message is Int) {
            builder.setMessage(message)
        } else if (message is String) {
            builder.setMessage(message)
        }
        builder.setPositiveButton(positiveAction, positiveListener)
        builder.setNegativeButton(android.R.string.cancel, null)
        builder.setCancelable(true)
        builder.show()
    }

    @LayoutRes
    open fun getLayoutIdLoading(): Int = -1

    /**
     * Init dialog loading
     */
    private fun initDialog() {
        val builder: AlertDialog.Builder = if (getThemResId() != -1)
            AlertDialog.Builder(requireActivity(), getThemResId()) else AlertDialog.Builder(requireActivity())

        builder.setCancelable(false)
        builder.setView(if (getLayoutIdLoading() == -1) R.layout.layout_loading_dialog_default else getLayoutIdLoading())
        loading = builder.create()
    }

    /**
     * Show dialog loading
     */
    open fun showLoadingDialog() {
        if (!loading.isShowing) {
            loading.show()
        }
    }

    /**
     * Hide dialog loading
     */
    open fun hideLoadingDialog() {
        if (loading.isShowing) {
            loading.dismiss()
        }
    }

    open fun goScreen(activity: Activity, activityClazz: Class<*>, isFinish: Boolean, vararg aniInt: Int?) {
        val intent = Intent(activity, activityClazz)
        startActivity(intent)
        if (isFinish) {
            activity.finish()
        }
        if(aniInt.size == 2) {
            activity.overridePendingTransition(aniInt[0] ?: 0, aniInt[1] ?: 0)
        }
    }
    fun doFinishActivity(){
        activity?.run {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    open fun onBackToParentFragment(){
        activity?.let{
            KeyboardUtil.hideSoftKeyBoard(it)
        }
        parentFragment?.childFragmentManager?.popBackStackImmediate()
    }

    open fun launchIntent(activity: Activity, intent: Intent, isFinish: Boolean, vararg aniInt: Int) {
        startActivity(intent)
        if(aniInt.size >= 2) {
            activity.overridePendingTransition(aniInt[0], aniInt[1])
        }
        if (isFinish) {
            activity.finish()
        }
    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }
}