package com.cevlikalprn.youneedtodo.common

sealed class AppResult<out T> {

    data class Success<T>(val data: T) : AppResult<T>()

    data class Error(val error: Throwable) : AppResult<Nothing>()
}
