package com.cevlikalprn.youneedtodo.common.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun ViewModel.ioScope(
    launch: suspend CoroutineScope.() -> Unit
) {
    viewModelScope.launch(Dispatchers.IO) {
        launch()
    }
}