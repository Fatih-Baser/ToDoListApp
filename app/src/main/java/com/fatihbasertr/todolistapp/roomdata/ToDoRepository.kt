package com.fatihbasertr.todolistapp.roomdata

import androidx.lifecycle.LiveData
import com.fatihbasertr.todolistapp.models.ToDoListDataModel


class ToDoRepository(private val dao: Dao) {

    val getAllData: LiveData<List<ToDoListDataModel>> = dao.getAllData()
    val sortByHighPriority: LiveData<List<ToDoListDataModel>> = dao.sortByHighPriority()
    val sortByLowPriority: LiveData<List<ToDoListDataModel>> = dao.sortByLowPriority()

    suspend fun insertData(toDoData: ToDoListDataModel){
        dao.insertData(toDoData)
    }

    suspend fun updateData(toDoData: ToDoListDataModel){
        dao.updateData(toDoData)
    }

    suspend fun deleteItem(toDoData: ToDoListDataModel){
        dao.deleteData(toDoData)
    }

    suspend fun deleteAll(){
        dao.deleteAll()
    }

    fun searchDatabase(searchQuery: String): LiveData<List<ToDoListDataModel>> {
        return dao.searchToDo(searchQuery)
    }

}