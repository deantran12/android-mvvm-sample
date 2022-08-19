package com.sonth.mvvm.sample.utils

import android.content.ClipData

class NameComparator : Comparator<String> {
    override fun compare(p0: String, p1: String): Int {
        return (p0).compareTo((p1))
    }
}
