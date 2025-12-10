/*
package com.example.recyclerviewdemo

import android.util.Log

class DataManager {

    val employees = mutableListOf<Employee>()

    private var nextId: Int

    init{
        initData()
        nextId = employees.size + 1
    }

    fun initData(){
        employees.add(Employee(1, "Bill",44,100.0))
        employees.add(Employee(2, "Arne",65,120.0))
        employees.add(Employee(3, "Cecilia",23,130.0))
        employees.add(Employee(4, "David",38,110.0))
    }

    fun addEmployee(name:String, age: Int, salary:Double){
        employees.add(Employee(nextId++, name,age,salary))
    }

    fun getEmployee(id:Int): Employee?{
        return employees.find { it.id == id }
    }

    fun updateEmployee(id:Int, name:String,age:Int,salary:Double){
        val index = employees.indexOfFirst { employee -> employee.id == id }
        if (index != -1){
            employees[index].name = name
            employees[index].age = age
            employees[index].salary = salary
        }
    }

    fun deleteEmployee(id:Int){

        employees.removeIf { employee -> employee.id == id }
    }

}
*/
