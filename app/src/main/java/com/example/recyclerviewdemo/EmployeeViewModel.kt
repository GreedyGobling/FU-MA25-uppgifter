package com.example.recyclerviewdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class EmployeeViewModel : ViewModel(){

    private val dataManager = FirebaseManager()

    //private val _employees = MutableLiveData<List<Employee>>(dataManager.employees.toList())
    //val employee: LiveData<List<Employee>> = _employees
    val employee: LiveData<MutableList<Employee>> = dataManager.employee
    private fun refresh(){
        //_employees.value = dataManager.employees.toList()
    }

    fun addEmployee(name: String, age:Int, salary:Double){
        dataManager.addEmployee(name,age,salary)
        refresh()
    }


    fun updateEmployee(id:String, name:String,age:Int,salary: Double){
        dataManager.updateEmployee(id,name,age,salary)
        refresh()
    }

    fun getEmployee(id:String): Employee?{
        return dataManager.getEmployee(id)
    }

    fun deleteEmployee(id:String){
        dataManager.deleteEmployee(id)
        refresh()
    }

}