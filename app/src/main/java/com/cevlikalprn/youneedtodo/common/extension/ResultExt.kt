package com.cevlikalprn.youneedtodo.common.extension

import com.cevlikalprn.youneedtodo.common.AppResult

suspend fun <T : Any?> AppResult<T?>.onSuccess(
    success: suspend (data: T?) -> Unit
): AppResult<T?> {
    if (this is AppResult.Success) {
        success(this.data)
    }
    return this
}

suspend fun <T : Any?> AppResult<T?>.onError(
    error: suspend (t: Throwable) -> Unit
): AppResult<T?> {
    if (this is AppResult.Error) {
        error(this.error)
    }
    return this
}