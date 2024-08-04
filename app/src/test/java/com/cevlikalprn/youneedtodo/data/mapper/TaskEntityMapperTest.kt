package com.cevlikalprn.youneedtodo.data.mapper

import com.cevlikalprn.youneedtodo.domain.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class TaskEntityMapperTest {

    private lateinit var taskEntityMapper: TaskEntityMapper

    @Before
    fun setup() {
        taskEntityMapper = TaskEntityMapper()
    }

    @Test
    fun taskEntityMapper_toDoTaskTransformsIntoToDoEntity_returnsTodoEntity() {
        val toDoTask = ToDoTask(
            id = 1,
            title = "title",
            description = "description",
            priority = Priority.LOW
        )
        val toDoTaskEntity = taskEntityMapper(toDoTask)
        assertEquals(toDoTask.title, toDoTaskEntity.title)
        assertEquals(toDoTask.description, toDoTaskEntity.description)
        assertEquals(toDoTask.priority, toDoTaskEntity.priority)
    }
}