package com.example.recyclerviewdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.recyclerviewdemo.databinding.FragmentEditBinding


private const val ARG_ID = "id"

class EditFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var employeeId: String? = null

    lateinit var viewModel: EmployeeViewModel

    lateinit var binding: FragmentEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[EmployeeViewModel::class.java]


        arguments?.let {
            employeeId = it.getString(ARG_ID)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEditBinding.inflate(inflater,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        if(employeeId != null && employeeId != null){
            loadTextFields(employeeId!!)
        }

        binding.btnCancel.setOnClickListener {
            requireActivity().supportFragmentManager.popBackStack()
        }

        binding.btnSave.setOnClickListener {

            val name = binding.etName.text.toString()
            val age = binding.etAge.text.toString().toIntOrNull() ?: 0
            val salary = binding.etSalary.text.toString().toDoubleOrNull() ?: 0.0

            if(employeeId == null){
                viewModel.addEmployee(name,age, salary)
            } else if(employeeId != null){
                viewModel.updateEmployee(employeeId!!,name,age,salary)
            }

            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    fun loadTextFields(id: String){
        val employee = viewModel.getEmployee(id)
        binding.etName.setText(employee?.name)
        binding.etSalary.setText(employee?.salary.toString())
        binding.etAge.setText(employee?.age.toString())
    }


    companion object {


        @JvmStatic
        fun newInstance(id: String?) =
            EditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_ID, id)

                }
            }
    }
}