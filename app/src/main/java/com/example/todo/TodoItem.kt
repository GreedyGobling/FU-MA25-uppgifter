package com.example.todo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// @Entity: Defines a table in the database.
// This is the blueprint for a "save file" or a row in a spreadsheet.
@Entity(tableName = "todo_items")
data class TodoItem(
    // @PrimaryKey: A unique ID for this specific item.
    // autoGenerate = true: The database assigns the ID automatically (1, 2, 3...) so we don't have to manage it.
    @PrimaryKey(autoGenerate = true) val id: Int,
    // @ColumnInfo: The name of the column where this data starts.
    @ColumnInfo(name = "task") var task: String,
    @ColumnInfo(name = "done") var done: Boolean
)