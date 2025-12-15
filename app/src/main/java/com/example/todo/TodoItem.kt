package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class TodoItem(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "task") var task: String,
    @ColumnInfo(name = "done") var done: Boolean
)