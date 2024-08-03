package com.cevlikalprn.youneedtodo.presentation.screen.task

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.common.Constants
import com.cevlikalprn.youneedtodo.data.FakeToDoRepository
import com.cevlikalprn.youneedtodo.data.mapper.TaskEntityMapper
import com.cevlikalprn.youneedtodo.data.mapper.TaskMapper
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.useCase.AddTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.DeleteTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.GetSelectedTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.UpdateTaskUseCase
import com.cevlikalprn.youneedtodo.presentation.model.Action
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class TaskViewModelTest {

    private lateinit var repository: FakeToDoRepository

    private lateinit var viewModel: TaskViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        repository = FakeToDoRepository()
        val testDispatcher = UnconfinedTestDispatcher()
        viewModel = TaskViewModel(
            GetSelectedTaskUseCase(repository, TaskMapper()),
            AddTaskUseCase(repository, TaskEntityMapper()),
            UpdateTaskUseCase(repository, TaskEntityMapper()),
            DeleteTaskUseCase(repository, TaskEntityMapper()),
            AppDispatchers(io = testDispatcher)
        )
        Dispatchers.setMain(testDispatcher)
    }

    @Test
    fun updateErrorMessage_whenErrorReceived_thenUpdateErrorMessage() {
        val errorMessage = "Invalid Error"
        viewModel.updateErrorMessage(errorMessage)
        assertEquals(errorMessage, viewModel.selectedTask.value.errorMessage)
    }

    @Test
    fun getSelectedTask_whenTaskIdProvided_thenSelectedTaskIsUpdated() = runTest {
        val taskToAdd = ToDoTaskEntity(10, "title", "desc", Priority.HIGH)
        repository.addTask(taskToAdd)
        viewModel.getSelectedTask(taskToAdd.id)
        val fetchedTask = viewModel.selectedTask.value.toDoTask
        assertTrue(taskToAdd.title == fetchedTask?.title)
        assertTrue(taskToAdd.description == fetchedTask?.description)
        assertTrue(taskToAdd.priority == fetchedTask?.priority)
    }

    @Test
    fun getSelectedTask_whenErrorReceived_thenUpdateErrorMessage() = runTest {
        val throwable = Throwable("Something went wrong")
        repository.setThrowable(throwable)
        viewModel.getSelectedTask(1)
        val fetchedErrorMessage = viewModel.selectedTask.value.errorMessage
        assertTrue(throwable.message == fetchedErrorMessage)
    }

    @Test
    fun updateTaskTitle_titleLengthExceedsLimit_titleNotUpdated() {
        var title = ""
        while (true) {
            if (title.length > Constants.MAX_TASK_TITLE_LENGTH) {
                break
            }
            title += "a"
        }
        viewModel.updateTaskTitle(title)
        assertTrue(viewModel.selectedTask.value.toDoTask?.title.isNullOrEmpty())
    }

    @Test
    fun updateTaskTitle_titleLengthWithinLimit_titleUpdated() {
        var title = ""
        while (true) {
            if (title.length < Constants.MAX_TASK_TITLE_LENGTH && title.isNotEmpty()) {
                break
            }
            title += "a"
        }
        viewModel.updateTaskTitle(title)
        assertTrue(viewModel.selectedTask.value.toDoTask?.title == title)
    }

    @Test
    fun updateTaskDescription_newDescription_descriptionUpdated() {
        val desc = "new desc"
        viewModel.updateTaskDescription(desc)
        assertTrue(viewModel.selectedTask.value.toDoTask?.description == desc)
    }

    @Test
    fun updateTaskPriority_newPriority_priorityUpdated() {
        val priority = Priority.HIGH
        viewModel.updateTaskPriority(priority)
        assertTrue(viewModel.selectedTask.value.toDoTask?.priority == priority)
    }

    @Test
    fun isReadyForAction_ifActionIsNotAddOrUpdate_returnsTrue() {
        val readyWithNoAction = viewModel.isReadyForAction(Action.NO_ACTION)
        assertTrue(readyWithNoAction)
        val readyWithDeleteAction = viewModel.isReadyForAction(Action.DELETE)
        assertTrue(readyWithDeleteAction)
    }

    @Test
    fun isReadyForAction_titleAndDescriptionIsEmpty_returnsFalse() {
        val readyWithAddAction = viewModel.isReadyForAction(Action.ADD)
        assertFalse(readyWithAddAction)
        val readyWithUpdateAction = viewModel.isReadyForAction(Action.UPDATE)
        assertFalse(readyWithUpdateAction)
    }

    @Test
    fun isReadyForAction_titleOrDescriptionIsEmpty_returnsFalse() = runTest {
        repository.addTask(ToDoTaskEntity(10, "", "desc", Priority.HIGH))
        viewModel.getSelectedTask(10)
        val readyWithAddAction = viewModel.isReadyForAction(Action.ADD)
        assertFalse(readyWithAddAction)
        val readyWithUpdateAction = viewModel.isReadyForAction(Action.UPDATE)
        assertFalse(readyWithUpdateAction)
    }

    @Test
    fun isReadyForAction_titleAndDescriptionIsNotEmpty_returnsTrue() = runTest {
        repository.addTask(ToDoTaskEntity(10, "title", "desc", Priority.HIGH))
        viewModel.getSelectedTask(10)
        val readyWithAddAction = viewModel.isReadyForAction(Action.ADD)
        assertTrue(readyWithAddAction)
        val readyWithUpdateAction = viewModel.isReadyForAction(Action.UPDATE)
        assertTrue(readyWithUpdateAction)
    }

    @Test
    fun applyAction_withAddAction_taskIsAdded() {
        updateSelectedTask()
        viewModel.applyAction(Action.ADD)
        viewModel.getSelectedTask(0)
        val toDoTask = viewModel.selectedTask.value.toDoTask
        assertTrue(toDoTask != null && toDoTask != ToDoTask.NewToDoTask)
    }

    @Test
    fun applyAction_withUpdateAction_taskIsUpdated() = runTest {
        repository.addTask(ToDoTaskEntity(10, "alperen", "cevlik", Priority.LOW))
        viewModel.getSelectedTask(10)
        updateSelectedTask()
        viewModel.applyAction(Action.UPDATE)
        viewModel.getSelectedTask(10)
        val toDoTask = viewModel.selectedTask.value.toDoTask
        assertTrue(toDoTask?.title == "Title" && toDoTask.description == "Desc")
    }

    @Test
    fun applyAction_withDeleteAction_taskIsDeleted() = runTest {
        repository.addTask(ToDoTaskEntity(10, "alperen", "cevlik", Priority.LOW))
        viewModel.getSelectedTask(10)
        viewModel.applyAction(Action.DELETE)
        viewModel.getSelectedTask(10)
        val toDoTask = viewModel.selectedTask.value.toDoTask
        assertTrue(toDoTask == ToDoTask.NewToDoTask)
    }

    private fun updateSelectedTask() {
        with(viewModel) {
            updateTaskTitle("Title")
            updateTaskDescription("Desc")
            updateTaskPriority(Priority.HIGH)
        }
    }
}
