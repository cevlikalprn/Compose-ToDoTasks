package com.cevlikalprn.youneedtodo.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cevlikalprn.youneedtodo.data.model.ToDoTask
import com.cevlikalprn.youneedtodo.util.Constants.DATABASE_VERSION

@Database(entities = [ToDoTask::class], version = DATABASE_VERSION, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}
