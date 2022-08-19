package com.sonth.mvvm.sample.base

import java.io.Serializable

abstract class BaseModel : Serializable{

    interface ItemClickListener {
        fun onItemClick()
    }

    abstract var listener: ItemClickListener?

    fun onClick() {
        listener?.onItemClick()
    }

}