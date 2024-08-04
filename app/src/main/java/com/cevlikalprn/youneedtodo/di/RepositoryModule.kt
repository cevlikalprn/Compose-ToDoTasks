package com.cevlikalprn.youneedtodo.di

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepositoryImpl
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideToDoRepository(
        todoDao: TodoDao,
        coroutineScope: CoroutineScope,
        appDispatchers: AppDispatchers
    ): ToDoRepository {
        return ToDoRepositoryImpl(
            todoDao = todoDao,
            externalScope = coroutineScope,
            appDispatchers = appDispatchers
        )
    }
}
