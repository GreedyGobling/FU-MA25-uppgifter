package com.example.todo

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

// @Dao: Data Access Object.
// Think of this as the "Control Panel" for your database. It defines all the actions you can perform (Save, Load, Delete).
@Dao
interface TodoDAO {

    //CRUD = CREATE,READ,UPDATE,DELETE => sql = INSERT,SELECT,UPDATE,DELETE

    @Insert
    // 'suspend': This function runs in the background (asynchronously).
    // It prevents the app from freezing (blocking the main thread) while writing to the database.
    suspend fun addTodo(item: TodoItem)

    // @Query: Allows us to speak directly to the database using SQL.
    // Flow: A live stream of data. If the database changes, this updates automatically—like a live scoreboard.
    @Query("SELECT * FROM todo_items")
    fun getAllTodo(): Flow<List<TodoItem>>

    @Update
    suspend fun updateTodo(item: TodoItem)

    @Delete
    suspend fun deleteTODO(item: TodoItem)
}