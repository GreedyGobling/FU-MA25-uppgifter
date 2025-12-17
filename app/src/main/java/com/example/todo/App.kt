package com.example.todo

import android.app.Application
import android.content.Context

// App: The starting point of the whole application.
// This class runs before anything else (even the first Activity).
class App: Application() {

    companion object{
        
        // We keep a static reference to the App instance so we can access 'Context' from anywhere.
        // Context is like the "Environment" the app runs in—needed for database builders, toasts, etc.
        lateinit var instance: App
            private set

        val context: Context
            get() = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}