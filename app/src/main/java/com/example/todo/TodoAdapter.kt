package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

class TodoAdapter(context: Context, itemList: List<TodoItem>, val updateItem: (TodoItem?)-> Unit): ArrayAdapter<TodoItem>(context,R.layout.layout_item, itemList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)

        val item = getItem(position)

        val task = view.findViewById<TextView>(R.id.tv_task)

        val checkbox = view.findViewById<CheckBox>(R.id.checkbox)

        task.text = item?.task

        checkbox.isChecked = item?.done == true

        checkbox.setOnClickListener {
            item?.done = checkbox.isChecked
            updateItem(item)
        }

        return view
    }

}