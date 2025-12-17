# Learning Notes: Android To-Do App Architecture

This project is a simple To-Do application designed to demonstrate modern Android development practices using **MVVM (Model-View-ViewModel)** architecture and **Room Database**.

## 🏗️ High-Level Structure

Think of the app as a restaurant:
1.  **UI (The Customer/Menu)**: Shows the food (data) and takes orders (user input).
2.  **ViewModel (The Waiter)**: Takes orders to the kitchen and brings food back. It remembers the order even if the customer looks away (screen rotation).
3.  **Repository (The Head Chef)**: Decides where to get ingredients (Local DB or Network).
4.  **DAO (The Line Cook)**: Knows exactly how to cook (query) the requested dish (data).
5.  **Database (The Pantry)**: Where all the raw ingredients (data) are stored.

## 📂 File Breakdown

### 1. Data Layer (The Save File)
*Location: `com.example.todo`*

*   **`TodoItem.kt` (@Entity)**
    *   **Role**: The "Blueprint".
    *   **Analogy**: A single row in a spreadsheet or a struct for a "Quest" in a game.
    *   **Key Concepts**: `@Entity` (Table), `@PrimaryKey` (Unique ID).

*   **`TodoDAO.kt` (Data Access Object)**
    *   **Role**: The "Control Panel".
    *   **Analogy**: A list of spells you can cast on the database (Insert, Delete, Select).
    *   **Key Concepts**: `@Dao`, `suspend` (Backgroud work), `Flow` (Live stream of data).

*   **`AppDataBase.kt`**
    *   **Role**: The "Vault".
    *   **Analogy**: The actual physical file where data lives.
    *   **Key Concepts**: `Singleton` (Only one vault door open at a time to prevent jamming).

### 2. Logic Layer (The Brains)
*Location: `com.example.todo`*

*   **`TodoRepository.kt`**
    *   **Role**: The "Gatekeeper".
    *   **Analogy**: A manager that provides a clean menu of data to the rest of the app, hiding the messy kitchen details (Database/Network logic).
    *   **Key Concepts**: Single Source of Truth.

*   **`TodoViewModel.kt`**
    *   **Role**: The "State Holder".
    *   **Analogy**: A memory bank that survives screen rotations. If the Activity dies (screen rotates), the ViewModel holds onto the data so it doesn't vanish.
    *   **Key Concepts**: `ViewModel`, `LiveData`, `viewModelScope`.

### 3. UI Layer (The Graphics)
*Location: `com.example.todo`*

*   **`MainActivity.kt`**
    *   **Role**: The "Screen".
    *   **Analogy**: The monitor displaying the game. It just observes data and renders it.
    *   **Key Concepts**: `ViewBinding`, `observe` (Reacting to changes).

*   **`TodoAdapter.kt`**
    *   **Role**: The "List Builder".
    *   **Analogy**: A specialized machine that takes raw data and stamps out UI widgets for every item in a scrolling list.
    *   **Key Concepts**: `RecyclerView` / `ListView` recycling (Reusing views to save memory).

## 🔑 Key Concepts Explained

*   **Room**: A library that makes using SQLite databases easier by using annotations like `@Entity` and `@Dao`.
*   **Coroutines (`suspend`)**: A way to run heavy tasks (like saving to a DB) on a background thread so the UI doesn't freeze.
*   **Flow / LiveData**: Pipes that deliver data updates automatically. If you change the DB, the UI updates instantly without refreshing.
