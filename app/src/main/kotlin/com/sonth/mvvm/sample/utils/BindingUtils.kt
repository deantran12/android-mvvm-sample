package com.sonth.mvvm.sample.utils

import android.graphics.BitmapFactory
import android.net.Uri
import android.text.TextWatcher
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sonth.mvvm.sample.R

enum class BatteryStatus(val percent: Int) {
    LEVEL_1(20),
    LEVEL_2(50),
    LEVEL_3(80),
    LEVEL_4(100),
    CHARGING(Integer.MAX_VALUE);
}

//@BindingAdapter("batteryStatusIcon")
//fun setBatteryStatusIcon(view: ImageView, batteryStatus: BatteryStatus) {
//    when (batteryStatus) {
//        BatteryStatus.CHARGING -> view.setImageResource(R.drawable.ic_battery_charging)
//        BatteryStatus.LEVEL_1 -> view.setImageResource(R.drawable.ic_battery_level_1)
//        BatteryStatus.LEVEL_2 -> view.setImageResource(R.drawable.ic_battery_level_2)
//        BatteryStatus.LEVEL_3 -> view.setImageResource(R.drawable.ic_battery_level_3)
//        BatteryStatus.LEVEL_4 -> view.setImageResource(R.drawable.ic_battery_level_4)
//    }
//}
//
//@BindingAdapter("lokrStatus")
//fun setLokrStatus(view: ImageView, isLock: Boolean) {
//    if (isLock) {
//        view.setImageResource(R.drawable.ic_lokr_lock)
//    } else {
//        view.setImageResource(R.drawable.ic_lokr_unlock)
//    }
//}

@BindingAdapter("height")
fun setHeight(view: View, height: Int) {
    val layoutParams = view.layoutParams
    if (height == 0) {
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT
    } else {
        layoutParams.height = height
    }
    view.layoutParams = layoutParams
}

@BindingAdapter("image")
fun setImage(view: ImageView, uri: Uri?) {
    uri?.let {
        Glide.with(view).load(uri).into(view)
    }
}

//@BindingAdapter("notificationAdapter")
//fun setNotificationAdapter(view: RecyclerView, list: List<Notification>?) {
//    list?.let {
//        val adapter = view.adapter as NotificationAdapter?
//        adapter?.clearItems()
//        adapter?.addItems(it)
//    }
//}
//
//@BindingAdapter("sharedAccessAdapter")
//fun setSharedAccessAdapter(view: RecyclerView, list: List<SharedAccess>?) {
//    list?.let {
//        val adapter = view.adapter as SharedAccessAdapter?
//        adapter?.clearItems()
//        adapter?.addItems(it)
//    }
//}

@BindingAdapter("customWidth")
fun setLayoutWidth(view: View, width: Int) {
    view.layoutParams = view.layoutParams.apply { this.width = width }
}

//@BindingAdapter("lokrAdapter")
//fun setLokrAdapter(view: RecyclerView, list: List<Lokr>?) {
//    list?.let {
//        val adapter = view.adapter as ListLokrAdapter?
//        adapter?.clearItems()
//        adapter?.addItems(it)
//    }
//}

@BindingAdapter("textChangedListener")
fun bindTextWatcher(editText: EditText, textWatcher: TextWatcher) {
    editText.addTextChangedListener(textWatcher)
}

//@BindingAdapter("newUnitAdapter")
//fun setNewUnitAdapter(view: RecyclerView, list: List<NewUnit>?) {
//    list?.let {
//        val adapter = view.adapter as NewUnitAdapter?
//        adapter?.clearItems()
//        adapter?.addItems(it)
//    }
//}


@BindingAdapter("battery")
fun setBattery(view: TextView, batteryLevel: Int?){
    batteryLevel?.let {
        view.text = "$it%"
    }
}

@BindingAdapter("buttonEnabled")
fun setEnable(view: TextView, isEnabled: Boolean){
    view.setTextColor(ContextCompat.getColor(view.context, if(isEnabled) R.color.primary else R.color.colorDisable))
    view.isEnabled = isEnabled
}