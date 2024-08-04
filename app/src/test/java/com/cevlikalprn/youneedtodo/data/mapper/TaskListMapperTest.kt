package com.cevlikalprn.youneedtodo.data.mapper

import com.cevlikalprn.youneedtodo.domain.mapper.TaskListMapper
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskListMapperTest {

    private lateinit var taskListMapper: TaskListMapper

    @Before
    fun setup() {
        taskListMapper = TaskListMapper()
    }

    @Test
    fun taskListMapper_toDoTaskEntityTransformsIntoToDoTask_returnsTodoTaskList() {
        val toDoTaskEntityList = listOf(
            ToDoTaskEntity(1, "title 1", "desc 1", Priority.NONE),
            ToDoTaskEntity(2, "title 2", "desc 2", Priority.LOW)
        )
        val todoTaskList = taskListMapper(toDoTaskEntityList)
        todoTaskList.forEachIndexed { index, toDoTask ->
            assertEquals(toDoTaskEntityList[index].id, toDoTask.id)
            assertEquals(toDoTaskEntityList[index].title, toDoTask.title)
            assertEquals(toDoTaskEntityList[index].description, toDoTask.description)
            assertEquals(toDoTaskEntityList[index].priority, toDoTask.priority)
        }
    }
}