package com.example.employeelist.ui.employee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.employeelist.databinding.EmployeeListFragmentBinding
import com.example.employeelist.ui.adapters.EmployeeAdapter
import com.example.employeelist.ui.employee.viewmodel.EmployeeViewModel
import com.example.employeelist.ui.model.models.Employee
import com.example.employeelist.ui.model.repository.EmployeeRepository

class EmployeeListFragment : Fragment() {
    private var _binding : EmployeeListFragmentBinding? = null
    private val binding : EmployeeListFragmentBinding get() = _binding!!

    private val viewModel : EmployeeViewModel by activityViewModels {
        EmployeeViewModel.Factory(EmployeeRepository)
    }

    private val adapter : EmployeeAdapter by lazy {
        EmployeeAdapter(::removeEmployee)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){
            employeeRv.apply {
                adapter = this@EmployeeListFragment.adapter
                layoutManager = LinearLayoutManager(requireContext())
            }
            viewModel.employees.observe(viewLifecycleOwner) {
                adapter.setData(it)
            }
        }
    }

    private fun removeEmployee(employee: Employee){
        viewModel.deleteEmployee(employee)
    }
}