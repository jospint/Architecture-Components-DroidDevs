package com.jospint.droiddevs.architecturecomponents.util.extension

import android.view.View
import com.jospint.droiddevs.architecturecomponents.util.SingleClickListener

fun View.singleClick(l: (android.view.View?) -> Unit) {
    setOnClickListener(SingleClickListener(l))
}