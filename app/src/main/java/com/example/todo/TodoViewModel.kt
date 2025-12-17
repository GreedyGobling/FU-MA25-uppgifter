package com.example.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

// ViewModel: The "Brain" of the screen.
// It holds data for the UI and survives configuration changes (like screen rotation).
// If the screen rotates, the Activity dies, but the ViewModel stays alive!
class TodoViewModel: ViewModel() {

    private val repo = TodoRepository()

    // LiveData: A wrapper for data that the UI can "Observe".
    // Unlike Flow (which is a steady stream), LiveData is aware of the Activity's lifecycle.
    // It only updates the UI when the Activity is actually on screen.
    val items: LiveData<List<TodoItem>> get() = repo.items.asLiveData()

    // viewModelScope: A safety net for background tasks.
    // Any internet/database job started here will be automatically cancelled if the ViewModel is cleared (e.g., user closes the app).
    // Dispatchers.IO: Run this on a background thread (not the main UI thread).
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