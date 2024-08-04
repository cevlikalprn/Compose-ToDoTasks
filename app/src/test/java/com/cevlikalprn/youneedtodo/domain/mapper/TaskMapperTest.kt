package com.cevlikalprn.youneedtodo.domain.mapper

import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskMapperTest {

    private lateinit var taskMapper: TaskMapper

    @Before
    fun setup() {
        taskMapper = TaskMapper()
    }

    @Test
    fun taskMapper_toDoTaskEntityTransformsIntoToDoTask_returnsTodoTask() {
        val toDoTaskEntity = ToDoTaskEntity(
            id = 1,
            title = "title",
            description = "description",
            priority = Priority.LOW
        )
        val toDoTask = taskMapper(toDoTaskEntity)
        assertEquals(toDoTaskEntity.id, toDoTask.id)
        assertEquals(toDoTaskEntity.title, toDoTask.title)
        assertEquals(toDoTaskEntity.description, toDoTask.description)
        assertEquals(toDoTaskEntity.priority, toDoTask.priority)
    }
}