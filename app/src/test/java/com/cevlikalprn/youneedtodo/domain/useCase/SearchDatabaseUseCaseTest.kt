package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class SearchDatabaseUseCaseTest {

    private lateinit var toDoRepository: FakeToDoRepository
    private lateinit var searchDatabaseUseCase: SearchDatabaseUseCase
    private val queryList = listOf("alperen", "alper", "alp", "eren")

    @Before
    fun setUp() {
        toDoRepository = FakeToDoRepository()
        searchDatabaseUseCase = SearchDatabaseUseCase(
            toDoRepository,
            TaskListMapper()
        )

        runBlocking {
            queryList.forEachIndexed { index, text ->
                val condition = index % 2 == 0

                val title = if (condition) text else "Title $index"
                val description = if (!condition) text else "Description $index"

                val task = ToDoTaskEntity(
                    id = index,
                    title = title,
                    description = description,
                    priority = Priority.NONE
                )

                toDoRepository.addTask(task)
            }
        }
    }

    @Test
    fun searchDatabase_matchesWithItemTitleOrDesc_returnsTrue() = runBlocking {
        val searchQuery = "alp"
        val tasks = searchDatabaseUseCase(searchQuery).first()
        tasks.forEach {
            assert(
                (it.title.contains(searchQuery, true)) ||
                        (it.description.contains(searchQuery, true))
            )
        }
    }
}