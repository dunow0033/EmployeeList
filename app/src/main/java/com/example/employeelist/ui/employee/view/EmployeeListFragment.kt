package com.example.employeelist.ui.employee.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.employeelist.databinding.EmployeeListFragmentBinding

class EmployeeListFragment : Fragment() {
    private var _binding : EmployeeListFragmentBinding? = null
    private val binding : EmployeeListFragmentBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EmployeeListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}