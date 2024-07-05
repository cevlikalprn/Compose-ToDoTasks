package com.cevlikalprn.youneedtodo.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
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
    fun addTask() = runBlocking {
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
}