package com.cevlikalprn.youneedtodo.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class TodoDaoTest {

    private lateinit var todoDatabase: TodoDatabase

    private lateinit var todoDao: TodoDao

    @Before
    fun setup() {
        todoDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TodoDatabase::class.java
        ).allowMainThreadQueries().build()
        todoDao = todoDatabase.todoDao()
    }

    @After
    fun teardown() {
        todoDatabase.close()
    }

    @Test
    fun getAllTasks_matchesWithAddedTasks_returnsTrue() = runBlocking {
        val taskToAdd = ToDoTaskEntity(1, "", "", Priority.LOW)
        todoDao.addTask(taskToAdd)
        todoDao.addTask(taskToAdd.copy(id = 2))
        val tasks = todoDao.getAllTasks().first()
        assert(tasks?.size == 2)
    }

    @Test
    fun getSelectedTask_matchesWithAddedTask_returnsTrue() = runBlocking {
        val taskToAdd = ToDoTaskEntity(1, "", "", Priority.LOW)
        todoDao.addTask(taskToAdd)
        val retrievedTask = todoDao.getSelectedTask(1).first()
        assert(retrievedTask == taskToAdd)
    }

    @Test
    fun addTask_addedTaskIsInTheList_returnsTrue() = runBlocking {
        val taskId = 100
        val entity = ToDoTaskEntity(
            id = taskId,
            title = "title",
            description = "desc",
            priority = Priority.LOW
        )
        todoDao.addTask(entity)
        val retrievedEntity = todoDao.getSelectedTask(taskId).first()
        assert(retrievedEntity == entity)
    }

    @Test
    fun updateTask_updatedTaskIsInTheList_returnsTrue() = runBlocking {
        val taskToAdd = ToDoTaskEntity(1, "title", "", Priority.LOW)
        todoDao.addTask(taskToAdd)
        val updatedTask = taskToAdd.copy(
            title = "updated title",
            description = "desc",
            priority = Priority.NONE
        )
        todoDao.updateTask(updatedTask)
        val retrievedTask = todoDao.getSelectedTask(1).first()
        assert(retrievedTask == updatedTask)
    }

    @Test
    fun deleteTask_deletedTaskIsNotInTheList_returnsTrue() = runBlocking {
        val taskToAdd = ToDoTaskEntity(1, "", "", Priority.LOW)
        todoDao.addTask(taskToAdd)
        todoDao.deleteTask(taskToAdd)
        val selectedTask = todoDao.getSelectedTask(taskToAdd.id).first()
        assert(selectedTask == null)
    }

    @Test
    fun deleteAllTasks_noTasksInTheList_returnsTrue() = runBlocking {
        val sampleTask = ToDoTaskEntity(1, "", "", Priority.LOW)
        for (i in 1..3) {
            todoDao.addTask(sampleTask.copy(id = i))
        }
        todoDao.deleteAllTasks()
        val tasks = todoDao.getAllTasks().first()
        assert(tasks.isNullOrEmpty())
    }

    @Test
    fun searchDatabase_searchedTasksAreListed_returnsTrue() = runBlocking {
        val sampleTask = ToDoTaskEntity(1, "alp", "alperen", Priority.LOW)
        val sampleTask2 = ToDoTaskEntity(2, "alper", "eren", Priority.LOW)
        todoDao.addTask(sampleTask)
        todoDao.addTask(sampleTask2)
        val searchedTasks = todoDao.searchDatabase("alperen").first()
        assert(searchedTasks.size == 1)
    }

    @Test
    fun sortByLowPriority_tasksSortedByLowPriority_returnsTrue() = runBlocking {
        val sampleTask = ToDoTaskEntity(1, "", "", Priority.HIGH)
        val sampleTask2 = ToDoTaskEntity(2, "", "", Priority.LOW)
        todoDao.addTask(sampleTask)
        todoDao.addTask(sampleTask2)
        val sortedTasks = todoDao.sortByLowPriority().first()
        assert(sortedTasks.first() == sampleTask2 && sortedTasks.last() == sampleTask)
    }

    @Test
    fun sortByHighPriority_tasksSortedByHighPriority_returnsTrue() = runBlocking {
        val sampleTask = ToDoTaskEntity(1, "", "", Priority.LOW)
        val sampleTask2 = ToDoTaskEntity(2, "", "", Priority.HIGH)
        todoDao.addTask(sampleTask)
        todoDao.addTask(sampleTask2)
        val sortedTasks = todoDao.sortByHighPriority().first()
        assert(sortedTasks.first() == sampleTask2 && sortedTasks.last() == sampleTask)
    }
}