package com.jospint.droiddevs.architecturecomponents.util.extension

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.ActivityCompat


inline fun <reified T : Activity> Activity.navigate(bundle: Bundle) {
    val intent = Intent(this, T::class.java)
    intent.putExtra("data", bundle);
    ActivityCompat.startActivity(this, intent, null)
}
