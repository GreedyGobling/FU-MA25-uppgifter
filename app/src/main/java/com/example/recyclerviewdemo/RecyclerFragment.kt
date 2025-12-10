package com.example.recyclerviewdemo

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewdemo.databinding.FragmentRecyclerBinding


class RecyclerFragment : Fragment() {



    lateinit var binding: FragmentRecyclerBinding

    lateinit var adapter: EmployeeRecyclerAdapter


    lateinit var viewModel : EmployeeViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[EmployeeViewModel::class.java]

        adapter = EmployeeRecyclerAdapter({ employee->

            showDeleteDialog(employee)
        },{ employee ->
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fc_main, EditFragment.newInstance(employee.id))
                addToBackStack(null)
                commit()
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecyclerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvEmployees.layoutManager = LinearLayoutManager(requireContext())
        binding.rvEmployees.addItemDecoration(SpaceItemDecoration(20))
        binding.rvEmployees.adapter = adapter

        binding.fabAdd.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fc_main, EditFragment.newInstance(null))
                addToBackStack(null)
                commit()
            }

        }

        viewModel.employee.observe(viewLifecycleOwner){
                list ->
            adapter.submitList(list)
        }


    }

    fun showDeleteDialog(employee:Employee){
        AlertDialog.Builder(requireActivity())
            .setTitle("Delete Employee")
            .setMessage("vill du radera användaren ${employee.name}")
            .setPositiveButton("Delete"){ a,b ->
                viewModel.deleteEmployee(employee.id)
            }.setNegativeButton("Cancel", null)
            .show()
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }

}

