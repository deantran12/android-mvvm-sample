package com.sonth.mvvm.sample.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

object NetworkUtils {
    fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        connectivityManager?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                it.getNetworkCapabilities(it.activeNetwork)?.let { capabilities ->
                    return when {
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                            true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                            true
                        }
                        capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                            true
                        }
                        else -> false
                    }
                }
            } else {
                try {
                    val activeNetworkInfo = it.activeNetworkInfo
                    if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                        LogUtil.info("update_status", "Network is available : true")
                        return true
                    }
                } catch (e: Exception) {
                    LogUtil.info("update_status", "" + e.message)
                }
                return false
            }
        }
        return false
    }
}