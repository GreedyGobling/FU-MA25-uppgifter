package com.example.todo

import kotlinx.coroutines.flow.Flow

class TodoRepository {
    private val todoDao = AppDataBase.getInstance().todoDao()

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