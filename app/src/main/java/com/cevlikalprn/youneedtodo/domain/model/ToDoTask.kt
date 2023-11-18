package com.cevlikalprn.youneedtodo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.cevlikalprn.youneedtodo.common.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
