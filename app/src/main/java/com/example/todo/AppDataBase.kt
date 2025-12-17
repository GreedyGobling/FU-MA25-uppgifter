package com.example.todo

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// @Database: The main access point for your database.
// It keeps track of all the tables (Entities) and the version history.
@Database(entities = [TodoItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun todoDao() : TodoDAO

    // Companion Object & Singleton Pattern:
    // We only want ONE instance of the database open at a time (Singleton).
    // Opening multiple connections is expensive and can lead to data conflicts (like trying to save two games at once).
    companion object{
        private var _instance: AppDataBase? = null

        fun getInstance(): AppDataBase{
            
            // If the instance exists, return it. If not, create it in a thread-safe way (synchronized).
            return _instance ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    App.context,
                    AppDataBase::class.java,
                    "todo_items"
                )
                    .fallbackToDestructiveMigration(true)
                    .build()
                _instance = instance
                instance
            }
        }
    }
}