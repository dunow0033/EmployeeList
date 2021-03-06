package com.example.employeelist.ui.employee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.example.employeelist.R
import com.example.employeelist.databinding.SignupFragmentBinding
import com.example.employeelist.ui.employee.viewmodel.EmployeeViewModel
import com.example.employeelist.ui.model.models.Employee
import com.example.employeelist.ui.model.repository.EmployeeRepository

class SignupFragment : Fragment() {
    private var _binding : SignupFragmentBinding? = null
    private val binding : SignupFragmentBinding get() = _binding!!

    private val viewModel : EmployeeViewModel by activityViewModels {
        EmployeeViewModel.Factory(EmployeeRepository())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = SignupFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val employeeListFragment = EmployeeListFragment()
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

        with(binding){
            submitButton.setOnClickListener {
                val employee = Employee(
                    name.toString(),
                    age.toString().toInt(),
                    job.toString(),
                    phoneNumber.toString()
                )

                viewModel.addEmployee(employee)
            }
//                transaction.replace(R.id.nav_host_fragment, employeeListFragment)
//                transaction.commit()
            }
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}