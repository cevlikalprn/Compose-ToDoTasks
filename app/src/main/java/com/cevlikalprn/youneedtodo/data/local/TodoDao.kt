package com.cevlikalprn.youneedtodo.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.cevlikalprn.youneedtodo.common.Constants.DATABASE_TABLE
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity

@Dao
interface TodoDao {

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY id DESC")
    suspend fun getAllTasks(): List<ToDoTaskEntity>?

    @Query("SELECT * FROM $DATABASE_TABLE WHERE id = :taskId")
    suspend fun getSelectedTask(taskId: Int): ToDoTaskEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTask(task: ToDoTaskEntity)

    @Update
    suspend fun updateTask(task: ToDoTaskEntity)

    @Delete
    suspend fun deleteTask(task: ToDoTaskEntity)

    @Query("DELETE FROM $DATABASE_TABLE")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM $DATABASE_TABLE WHERE title LIKE '%' || :searchQuery || '%' OR description LIKE '%' || :searchQuery || '%'")
    suspend fun searchDatabase(searchQuery: String): List<ToDoTaskEntity>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    suspend fun sortByLowPriority(): List<ToDoTaskEntity>

    @Query("SELECT * FROM $DATABASE_TABLE ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    suspend fun sortByHighPriority(): List<ToDoTaskEntity>
}
