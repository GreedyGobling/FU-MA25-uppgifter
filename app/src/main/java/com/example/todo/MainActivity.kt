package com.example.todo

import android.os.Binder
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.GeneratedAdapter
import androidx.lifecycle.ViewModelProvider
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private var itemList = mutableListOf<TodoItem>()
    lateinit var  vm: TodoViewModel
    lateinit var itemAdapter: ArrayAdapter<TodoItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this).get(TodoViewModel::class.java)

        vm.items.observe(this){items ->
            itemList.clear()
            itemList.addAll(items)
            itemAdapter.notifyDataSetChanged()
        }

        itemAdapter = TodoAdapter(this, itemList){ item ->
            if (item != null){
                vm.updateItem(item)
            }
        }

        binding.lvTasks.adapter = itemAdapter

        binding.btnAdd.setOnClickListener {
            if (binding.etName.text.isNotBlank()){
                val task = binding.etName.text.toString()
                val todo = TodoItem(0, task, false)

                vm.saveItem(todo)
            }
        }

        binding.lvTasks.onItemLongClickListener = AdapterView.OnItemLongClickListener{ parent, view, pos, id ->
            val item = parent.getItemAtPosition(pos) as TodoItem
            vm.deleteItem(item).isCompleted
        }
    }
}