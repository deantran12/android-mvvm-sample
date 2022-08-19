package com.sonth.mvvm.sample.utils

import android.app.Activity
import android.content.Context
import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.sonth.mvvm.sample.data.local.User
import javax.inject.Inject

class SharedConfig @Inject constructor(context: Context, val gson: Gson) {
    companion object{
        const val APP_PREFERENCES = "AppPreferences"
        const val USER = "user"
    }

    private val sharedPreferences =
        context.getSharedPreferences(APP_PREFERENCES, Activity.MODE_PRIVATE)

    fun saveUser(user: User){
        val info = gson.toJson(user)
        sharedPreferences.edit().putString(USER, info).apply()
    }

    fun getUser() : User?{
        val info = sharedPreferences.getString(USER, "")
        if(info.isNullOrEmpty()){
            return null
        }

        try {
            return gson.fromJson(info, User::class.java)
        } catch (e: JsonParseException) {
            e.printStackTrace()
        }

        return null
    }

}