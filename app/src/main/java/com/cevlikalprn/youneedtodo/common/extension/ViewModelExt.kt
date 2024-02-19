package com.cevlikalprn.youneedtodo.common.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun ViewModel.ioScope(
    launch: suspend CoroutineScope.() -> Unit,
    error: suspend CoroutineScope.(e: Exception) -> Unit = {}
) {
    viewModelScope.launch {
        withContext(Dispatchers.IO) {
            try {
                launch()
            } catch (e: Exception) {
                error(e)
            }
        }
    }
}