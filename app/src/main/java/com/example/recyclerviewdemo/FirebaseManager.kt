package com.example.recyclerviewdemo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class FirebaseManager {

    private val db = Firebase.firestore

    private val _employees = MutableLiveData(mutableListOf<Employee>())

    val employee: LiveData<MutableList<Employee>> get() = _employees

    init {
        addSnapshotListener()
    }

    fun getEmployee(id:String): Employee?{
        return employee.value?.find {it.id == id}
    }

    fun addSnapshotListener(){

        db.collection("employees").addSnapshotListener { snapshot, error ->

            if (snapshot != null){
                val tempList = mutableListOf<Employee>()

                // doc(age,name,salary) -> employe("",name,age,salary).copy -> employee("doc.id",name,age,salary)
                for (doc in snapshot.documents){
                    val employee = doc.toObject(Employee::class.java)!!.copy(id = doc.id)

                    tempList.add(employee)
                }

                _employees.value = tempList
            }
        }
    }

    fun addEmployee(name:String, age:Int, salary:Double){
        val fields = mapOf(
            "name" to name,
            "age" to age,
            "salary" to salary
        )

        db.collection("employees").add(fields).addOnSuccessListener { documentReference ->
            Log.i("SOUT", "added employee to database with id: " + documentReference.id)
        }.addOnFailureListener {
            Log.e("SOUT", "failed to add employee to database, error: " + it.message)
        }
    }

    fun updateEmployee(id:String, name:String,age:Int,salary:Double){
        val fields = mapOf(
            "name" to name,
            "age" to age,
            "salary" to salary
        )

        db.collection("employees")
            .document(id)
            .update(fields).addOnSuccessListener { documentReference ->
                Log.i("SOUT","updated employee to database with id: $id")
            }.addOnFailureListener {
                Log.e("SOUT","failed to update employee to database, error: " + it.message)
            }
    }

    fun deleteEmployee(id:String){
        db.collection("employees").document(id).delete().addOnSuccessListener {
                Log.i("SOUT", "added employee to database with id: $id")
            }.addOnFailureListener {
                Log.e("SOUT", "failed to add employee to database, error: " + it.message)
            }
        }

}