package com.example.todo

import kotlinx.coroutines.flow.Flow

// Repository: acts as a "Gatekeeper" or "Manager" for data.
// It decides where to get data from (Local DB, Network, etc.) so the UI doesn't have to worry about it.
class TodoRepository {
    private val todoDao = AppDataBase.getInstance().todoDao()

    // We expose the Flow (Live Stream) from the DAO.
    // The Repository passes this stream up to the ViewModel.
    val items: Flow<List<TodoItem>> = todoDao.getAllTodo()


   suspend fun addTodo(item: TodoItem){
        todoDao.addTodo(item)
    }
    suspend fun updateTodo(item: TodoItem){
        todoDao.updateTodo(item)
    }
    suspend fun deleteTODO(item: TodoItem){
        todoDao.deleteTODO(item)
    }

}