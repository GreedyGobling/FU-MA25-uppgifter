package com.example.recyclerviewdemo

data class Employee(var id: String = "", var name: String, var age: Int, var salary: Double){

    constructor():this("","",0,0.0)
}
