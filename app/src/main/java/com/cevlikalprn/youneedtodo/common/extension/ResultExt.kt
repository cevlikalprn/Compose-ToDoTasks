package com.cevlikalprn.youneedtodo.common.extension

import com.cevlikalprn.youneedtodo.common.AppResult

fun <T : Any> AppResult<T>.onSuccess(
    success: (data: T) -> Unit
): AppResult<T> {
    if (this is AppResult.Success) {
        success(this.data)
    }
    return this
}

fun <T : Any> AppResult<T>.onError(
    error: (t: Throwable) -> Unit
): AppResult<T> {
    if (this is AppResult.Error) {
        error(this.error)
    }
    return this
}