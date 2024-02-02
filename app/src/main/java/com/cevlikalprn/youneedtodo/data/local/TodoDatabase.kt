package com.cevlikalprn.youneedtodo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.common.Constants.DATABASE_VERSION

@Database(entities = [ToDoTaskEntity::class], version = DATABASE_VERSION, exportSchema = false)
abstract class TodoDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}
