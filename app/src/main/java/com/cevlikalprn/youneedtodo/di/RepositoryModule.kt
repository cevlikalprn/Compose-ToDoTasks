package com.cevlikalprn.youneedtodo.di

import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepositoryImpl
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideToDoRepository(
        todoDao: TodoDao
    ): ToDoRepository {
        return ToDoRepositoryImpl(todoDao)
    }
}
