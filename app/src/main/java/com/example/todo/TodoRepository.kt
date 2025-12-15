package com.example.todo

import kotlinx.coroutines.flow.Flow

class TodoRepository {
    private val todoDao = AppDataBase.getInstance().todoDao()

    val items: Flow<List<TodoItem>> = todoDao.getAllTodo()


    fun addTodo(item: TodoItem){
        todoDao.addTodo(item)
    }
    fun updateTodo(item: TodoItem){
        todoDao.updateTodo(item)
    }
    fun deleteTODO(item: TodoItem){
        todoDao.deleteTODO(item)
    }

}