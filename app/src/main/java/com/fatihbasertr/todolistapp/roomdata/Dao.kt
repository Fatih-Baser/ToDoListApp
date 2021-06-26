package com.fatihbasertr.todolistapp.roomdata

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.fatihbasertr.todolistapp.models.ToDoListDataModel

@Dao
interface Dao {

    @Query("SELECT * FROM todolist_table ORDER BY id ASC")
    fun getAllData(): LiveData<List<ToDoListDataModel>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoListDataModel)

    @Update
    suspend fun updateData(toDoData: ToDoListDataModel)

    @Delete
    suspend fun deleteData(toDoData: ToDoListDataModel)

    @Query("DELETE FROM todolist_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM todolist_table WHERE title LIKE :searchQuery")
    fun searchToDo(searchQuery: String): LiveData<List<ToDoListDataModel>>

    @Query("SELECT * FROM todolist_table ORDER BY CASE WHEN priority LIKE 'H%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'L%' THEN 3 END")
    fun sortByHighPriority(): LiveData<List<ToDoListDataModel>>

    @Query("SELECT * FROM todolist_table ORDER BY CASE WHEN priority LIKE 'L%' THEN 1 WHEN priority LIKE 'M%' THEN 2 WHEN priority LIKE 'H%' THEN 3 END")
    fun sortByLowPriority(): LiveData<List<ToDoListDataModel>>
}