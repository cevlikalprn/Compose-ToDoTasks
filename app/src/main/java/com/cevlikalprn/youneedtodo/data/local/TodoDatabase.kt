package com.cevlikalprn.youneedtodo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cevlikalprn.youneedtodo.data.local.util.Constants.DATABASE_VERSION
import com.cevlikalprn.youneedtodo.data.local.model.ToDoTaskEntity

@Database(entities = [ToDoTaskEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}
