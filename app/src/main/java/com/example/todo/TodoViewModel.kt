package com.example.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel: ViewModel() {

    private val repo = TodoRepository()

    val items: LiveData<List<TodoItem>> get() = repo.items.asLiveData()

    fun saveItem(item: TodoItem) = viewModelScope.launch(Dispatchers.IO){
        repo.addTodo(item)
    }

    fun updateItem(item: TodoItem) = viewModelScope.launch(Dispatchers.IO){
        repo.updateTodo(item)
    }
    fun deleteItem(item: TodoItem) = viewModelScope.launch(Dispatchers.IO){
        repo.deleteTODO(item)
    }

}