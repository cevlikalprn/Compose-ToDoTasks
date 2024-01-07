package com.cevlikalprn.youneedtodo.common.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun ViewModel.launchInIo(
    launchBlock: suspend CoroutineScope.() -> Unit,
    errorBlock: (error: Exception) -> Unit
) {
    try {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                launchBlock()
            }
        }
    } catch (e: Exception) {
        errorBlock(e)
    }
}