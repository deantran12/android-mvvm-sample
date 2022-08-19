package com.sonth.mvvm.sample.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.util.Base64
import androidx.core.app.ActivityCompat
import com.sonth.mvvm.sample.feature.start.StartActivity
import java.nio.charset.StandardCharsets
import kotlin.math.roundToInt


object CommonUtils {
    fun hasPermissions(context: Context, vararg permissions: String): Boolean = permissions.all {
        ActivityCompat.checkSelfPermission(context, it) == PackageManager.PERMISSION_GRANTED
    }

    fun pxToDp(px: Int): Int {
        return (px / Resources.getSystem().displayMetrics.density).roundToInt()
    }

    fun getBase64Encoded(key: String): String {
        val encodedBytes = Base64.encode(key.toByteArray(), Base64.NO_WRAP)
        return String(encodedBytes, StandardCharsets.UTF_8)
    }

    fun restartApp(activity: Activity){
        val intent = Intent(activity, StartActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        activity.startActivity(intent)
        activity.finish()
    }
}