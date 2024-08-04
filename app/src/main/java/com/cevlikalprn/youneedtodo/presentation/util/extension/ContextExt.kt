package com.cevlikalprn.youneedtodo.presentation.util.extension

import android.content.Context
import android.widget.Toast

fun Context.longToastMessage(message: String) {
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}