package com.example.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoDAO {

    //CRUD = CREATE,READ,UPDATE,DELETE => sql = INSERT,SELECT,UPDATE,DELETE

    @Insert
    fun addTodo(item: TodoItem)

    @Query("SELECT * FROM todo_items")
    fun getAllTodo(): Flow<List<TodoItem>>

    @Update
    fun updateTodo(item: TodoItem)

    @Delete
    fun deleteTODO(item: TodoItem)
}