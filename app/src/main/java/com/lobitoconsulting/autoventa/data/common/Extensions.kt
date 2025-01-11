package com.lobitoconsulting.autoventa.data.common

import android.content.Context
import android.util.Log
import android.widget.Toast

inline fun <reified T> T.logi(message: String) = Log.i(T::class.java.simpleName, message)
inline fun <reified T> T.logerror(message: String) = Log.e(T::class.java.simpleName, message)
fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}
