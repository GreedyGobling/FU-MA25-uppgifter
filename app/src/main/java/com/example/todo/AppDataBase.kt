package com.example.todo

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TodoItem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun todoDao() : TodoDAO

    companion object{
        private var _instance: AppDataBase? = null

        fun getInstance(): AppDataBase{

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