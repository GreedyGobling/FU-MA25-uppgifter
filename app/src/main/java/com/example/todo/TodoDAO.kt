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
    suspend fun addTodo(item: TodoItem)

    @Query("SELECT * FROM todo_items")
    fun getAllTodo(): Flow<List<TodoItem>>

    @Update
    suspend fun updateTodo(item: TodoItem)

    @Delete
    suspend fun deleteTODO(item: TodoItem)
}