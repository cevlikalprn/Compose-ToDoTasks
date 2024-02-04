package com.cevlikalprn.youneedtodo.common.extension

import android.content.Context
import android.widget.Toast

fun Context.shortToastMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun Context.longToastMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}