package com.cevlikalprn.youneedtodo.common.extension

import com.cevlikalprn.youneedtodo.common.AppResult
import com.cevlikalprn.youneedtodo.domain.repository.AppRepository

suspend fun <T : Any?> AppRepository.repoCall(
    repoCall: (suspend () -> T?)
): AppResult<T?> {
    return try {
        AppResult.Success(repoCall.invoke())
    } catch (t: Throwable) {
        AppResult.Error(t)
    }
}
