package com.example.recyclerviewdemo

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewdemo.databinding.ListItemEmployeeBinding

class EmployeeRecyclerAdapter( val onItemLongClick:(Employee) -> Unit, val onItemClick: (Employee) -> Unit) : RecyclerView.Adapter<EmployeeRecyclerAdapter.EmployeeViewHolder>(){

    private var employees = emptyList<Employee>()


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeViewHolder {
       val binding = ListItemEmployeeBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return EmployeeViewHolder(binding)
    }


    fun submitList(employeeList: List<Employee>){
        employees = employeeList
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(
        holder: EmployeeViewHolder,
        position: Int
    ) {
       val employee = employees[position]

        holder.binding.tvName.text = employee.name
        holder.binding.tvSalary.text = "salary: ${employee.salary}"
        holder.binding.tvAge.text = "age: ${employee.age}"

        holder.binding.root.setOnClickListener {
           onItemClick(employee)
        }

        holder.binding.root.setOnLongClickListener {

            onItemLongClick(employee)
            true
        }

    }



    override fun getItemCount(): Int {
       return employees.size
    }


    class EmployeeViewHolder(val binding: ListItemEmployeeBinding): RecyclerView.ViewHolder(binding.root)
}