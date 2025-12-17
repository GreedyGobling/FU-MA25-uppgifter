package com.example.todo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.TextView

// Adapter: The bridge between your data (List<TodoItem>) and the UI (ListView).
// It takes each item and converts it into a View to be displayed.
class TodoAdapter(context: Context, itemList: List<TodoItem>, val updateItem: (TodoItem?)-> Unit): ArrayAdapter<TodoItem>(context,R.layout.layout_item, itemList) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        // getView: Called for every item that needs to be shown on screen.
        // 'convertView': Represents a "recycled" view that scrolled off-screen. Reusing it saves memory!
        // regarding the ?: operator: If convertView is null (new view), we inflate it. If not, we reuse it.
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