package com.sonth.mvvm.sample.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast

object ToastUtil{
    fun showToast(context: Context?, message: Any){
        context?.let {
            val mes: String = when (message) {
                is Int -> it.getString(message)
                is String -> message
                else -> ""
            }
            val toast = Toast.makeText(it, mes, Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()
        }
    }
}